package com.github.timurnabiyev.postgresql_course.dao;

import com.github.timurnabiyev.postgresql_course.models.CustomerDemographics;

public interface CustomerDemographicsDao {
    public CustomerDemographics find(Long customerDemographicId);
    public CustomerDemographics save(CustomerDemographics customerDemographics);
}
