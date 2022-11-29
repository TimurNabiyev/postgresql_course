package com.github.timurnabiyev.postgresql_course.dao;

import com.github.timurnabiyev.postgresql_course.models.UsStates;

public interface UsStatesDao {
    public UsStates find(Long usStatesId);
    public UsStates save(UsStates usStates);
}
