package ru.kpfu.itis.way;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.kpfu.itis.way.models.CompletedWay;
import ru.kpfu.itis.way.service.BenchmarkService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class UserWayApplication implements CommandLineRunner {

    @Autowired
    private BenchmarkService benchmarkService;

    public static void main(String[] args) {
        SpringApplication.run(UserWayApplication.class, args);
    }

    @Override
    public void run(String... args) {
//        Double tps = benchmarkService.doBenchmark();
//
//        String filename = "cassandra" + new Date().getTime() + ".txt";
//        try (FileWriter writer = new FileWriter(filename, false)) {
//            writer.write(tps.toString());
//
//            writer.flush();
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        System.out.println(tps);

        String filename = "druid" + new Date().getTime() + ".json";

        System.out.println("generate");
        List<CompletedWay> data = benchmarkService.generateData();
        System.out.println("generated");
        try (FileWriter writer = new FileWriter(filename, false)) {
            for (CompletedWay completedWay :
                    data) {
                writer.write(new ObjectMapper().writeValueAsString(completedWay));
                writer.write(System.lineSeparator());
            }
            System.out.println("write");

            writer.flush();
            System.out.println("written");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
