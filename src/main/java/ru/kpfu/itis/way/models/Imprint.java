package ru.kpfu.itis.way.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Builder
@Table
public class Imprint {

    @PrimaryKey
    private String id;

    private String imprint;
}
