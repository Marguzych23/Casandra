package ru.kpfu.itis.way;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import ru.kpfu.itis.way.service.BenchmarkService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

@SpringBootApplication
@EnableCassandraRepositories
public class UserWayApplication implements CommandLineRunner {

    @Autowired
    private BenchmarkService benchmarkService;

    public static void main(String[] args) {
        SpringApplication.run(UserWayApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Double tps = benchmarkService.doBenchmark();

        String filename = "cassandra" + new Date().getTime() + ".txt";
        try (FileWriter writer = new FileWriter(filename, false)) {
            writer.write(tps.toString());

            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(tps);
    }
}
