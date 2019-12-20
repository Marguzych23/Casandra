package ru.kpfu.itis.advertising.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;

@Data
@Builder
@Table
public class Imprint {

    @PrimaryKey
    private Long id;

    private String imprint;
}
