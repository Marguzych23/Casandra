package ru.kpfu.itis.advertising.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;

@Data
@Builder
@Table
public class UncompletedWay {

    @PrimaryKey
    private String imprint;

    private Integer way;
    private Date startTime;
}
