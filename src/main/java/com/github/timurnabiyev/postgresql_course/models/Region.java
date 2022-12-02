package com.github.timurnabiyev.postgresql_course.models;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Region {
    private Integer regionId;
    private String regionDescription;
}