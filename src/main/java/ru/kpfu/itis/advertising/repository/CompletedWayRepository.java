package ru.kpfu.itis.advertising.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.advertising.models.CompletedWay;

@Repository
public interface CompletedWayRepository extends CassandraRepository<CompletedWay, String> {
}
