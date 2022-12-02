package com.github.timurnabiyev.postgresql_course.models;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UsStates {

    private Integer stateId;
    private String stateName;
    private String stateAbbr;
    private String stateRegion;

}
