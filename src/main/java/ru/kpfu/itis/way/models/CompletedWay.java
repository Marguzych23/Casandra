package ru.kpfu.itis.way.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;

@Data
@Builder
@Table
public class CompletedWay {

    @PrimaryKey
    private Long id;

    private String imprint;
    private String way;
    private Boolean isFirst;
    private Date startTime;
    private Date endTime;
}
