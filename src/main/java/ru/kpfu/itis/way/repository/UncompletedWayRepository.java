package ru.kpfu.itis.way.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.way.models.UncompletedWay;

@Repository
public interface UncompletedWayRepository extends CassandraRepository<UncompletedWay, String> {
}
