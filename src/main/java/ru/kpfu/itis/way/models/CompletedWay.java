package ru.kpfu.itis.way.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Builder
@Getter
@Setter
public class CompletedWay {
    private Date __time;

    private String imprint;
    private String way;
    private Boolean isFirst;
    private String startTime;
    private String endTime;
}
