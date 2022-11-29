package com.github.timurnabiyev.postgresql_course.dao;

import com.github.timurnabiyev.postgresql_course.models.Territories;

public interface TerritoriesDao {
    public Territories find(Long territoryId);
    public Territories save(Territories territories);
}
