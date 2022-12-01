package com.github.timurnabiyev.postgresql_course.dao;

import com.github.timurnabiyev.postgresql_course.models.UsStates;

import java.sql.ResultSet;

public interface UsStatesDao {
    public UsStates findUsStatesByID(Long usStatesId);
    public Long insertUsStates(UsStates usStates);
    public int getUsStatesCount();
    public void getUsStates();
    public int updateUsState(Long id, UsStates usState);
    public int deleteUsState(Long id);
}
