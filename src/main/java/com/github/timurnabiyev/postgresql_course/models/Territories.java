package com.github.timurnabiyev.postgresql_course.models;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Territories {
    private String territoryId;
    private String territoryDescription;
    private Integer regionId;

}