package com.github.timurnabiyev.postgresql_course.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
public class Territories {
    private String territoryId;
    private String territoryDescription;
    private Integer regionId;

    public Territories(String territoryId, String territoryDescription, Integer regionId) {
        this.territoryId = territoryId;
        this.territoryDescription = territoryDescription;
        this.regionId = regionId;
    }

}