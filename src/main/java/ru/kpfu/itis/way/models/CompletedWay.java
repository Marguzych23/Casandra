package ru.kpfu.itis.way.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;

@Data
@Builder
@Table
@Getter
@Setter
public class CompletedWay {

    @PrimaryKey
    private Date __time;

    private String imprint;
    private String way;
    private Boolean isFirst;
    private String startTime;
    private String endTime;
}
