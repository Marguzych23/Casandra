package ru.kpfu.itis.advertising;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import ru.kpfu.itis.advertising.service.BenchmarkService;

@SpringBootApplication
@EnableCassandraRepositories
public class TargetedAdvertisingApplication implements CommandLineRunner {

    @Autowired
    private BenchmarkService benchmarkService;

    public static void main(String[] args) {
        SpringApplication.run(TargetedAdvertisingApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Double tps = benchmarkService.doBenchmark();
        System.out.println(tps);
    }
}
