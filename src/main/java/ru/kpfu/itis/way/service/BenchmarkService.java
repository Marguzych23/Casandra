package ru.kpfu.itis.way.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.way.models.*;
import ru.kpfu.itis.way.repository.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class BenchmarkService {

    private final CompletedWayRepository completedWayRepository;
    private final UncompletedWayRepository uncompletedWayRepository;
    private final ImprintRepository imprintRepository;

    public Double doBenchmarkOneTable() {
        long start = System.currentTimeMillis();

        int transactionCount = 10;
        for (int i = 0; i < transactionCount; i++) {
            String imprint = generateId();

            completedWayRepository.save(generateCompletedWayModelWithRandomData(imprint));

            System.out.println(imprint);
        }
        long stop = System.currentTimeMillis();

        return (double) transactionCount / ((stop - start) / 1000.0);
    }

    public Double doBenchmark() {
        int transactionCount = 10000;
        int completedWayTransactionCount = 5;
        int uncompletedWayTransactionCount = 1;
        int imprintWayTransactionCount = 1;

        long start = System.currentTimeMillis();

        for (int i = 0; i < transactionCount; i++) {
            String imprint = generateId();

            imprintRepository.save(generateImprintModelWithRandomData(imprint));

            uncompletedWayRepository.save(generateUncompletedWayModelWithRandomData(imprint));

            for (int j = 0; j < completedWayTransactionCount; j++) {
                completedWayRepository.save(generateCompletedWayModelWithRandomData(imprint));
            }
        }
        long stop = System.currentTimeMillis();

        return (double) (transactionCount
                * (completedWayTransactionCount + uncompletedWayTransactionCount + imprintWayTransactionCount))
                / ((stop - start) / 1000.0);
    }

    private CompletedWay generateCompletedWayModelWithRandomData(String imprint) {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        return CompletedWay.builder()
                .id(generateId())
                .imprint(imprint)
                .way(imprint + imprint + imprint)
                .isFirst(random.nextBoolean())
                .startTime(new Date().toString())
                .endTime(new Date().toString())
                .build();
    }

    private UncompletedWay generateUncompletedWayModelWithRandomData(String imprint) {
        return UncompletedWay.builder()
                .imprint(imprint)
                .way(imprint + imprint + imprint)
                .startTime(new Date())
                .build();
    }

    private Imprint generateImprintModelWithRandomData(String imprint) {
        return Imprint.builder()
                .id(generateId())
                .imprint(imprint)
                .build();
    }

    private String generateId() {
        return UUID.randomUUID().toString()
                + UUID.randomUUID().toString()
                + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
    }
}
