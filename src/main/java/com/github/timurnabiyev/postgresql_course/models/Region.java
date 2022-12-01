package com.github.timurnabiyev.postgresql_course.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
public class Region {
    private Integer regionId;
    private String regionDescription;

    public Region(Integer regionId, String regionDescription) {
        this.regionId = regionId;
        this.regionDescription = regionDescription;
    }

}