package com.github.timurnabiyev.postgresql_course.dao;

import com.github.timurnabiyev.postgresql_course.models.Region;

public interface RegionDao {
    public Region find(Long regionId);
    public Region save(Region region);
}
