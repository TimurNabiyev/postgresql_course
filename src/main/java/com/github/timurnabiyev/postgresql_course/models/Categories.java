package com.github.timurnabiyev.postgresql_course.models;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Categories {
    private Integer categoryId;
    private String categoryName;
    private String description;
    private Short picture;

}
