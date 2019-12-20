package ru.kpfu.itis.way.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.way.models.CompletedWay;

@Repository
public interface CompletedWayRepository extends CassandraRepository<CompletedWay, String> {
}
