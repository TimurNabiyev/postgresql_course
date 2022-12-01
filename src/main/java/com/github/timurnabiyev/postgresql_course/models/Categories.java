package com.github.timurnabiyev.postgresql_course.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
public class Categories {
    private Integer categoryId;
    private String categoryName;
    private String description;
    private Short picture;


    public Categories(Integer categoryId, String categoryName, String description, Short picture) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.picture = picture;
    }

}
