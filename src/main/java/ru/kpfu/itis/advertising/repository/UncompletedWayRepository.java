package ru.kpfu.itis.advertising.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.advertising.models.UncompletedWay;

@Repository
public interface UncompletedWayRepository extends CassandraRepository<UncompletedWay, String> {
}
