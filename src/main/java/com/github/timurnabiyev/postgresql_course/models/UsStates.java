package com.github.timurnabiyev.postgresql_course.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@ToString
public class UsStates {

    private Integer stateId;
    private String stateName;
    private String stateAbbr;
    private String stateRegion;

    public UsStates(Integer stateId, String stateName, String stateAbbr, String stateRegion) {
        this.stateId = stateId;
        this.stateName = stateName;
        this.stateAbbr = stateAbbr;
        this.stateRegion = stateRegion;
    }


}
