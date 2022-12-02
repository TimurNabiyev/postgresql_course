package com.github.timurnabiyev.postgresql_course.models;

import lombok.*;

import java.net.URL;
import java.time.LocalDate;
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employees {
    private Long employeeId;
    private String lastName;
    private String firstName;
    private String title;
    private String titleOfCourtesy;
    private LocalDate birthDate;
    private LocalDate hireDate;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String homePhone;
    private String extension;
    private String photo;
    private String notes;
    private Integer reportsTo;
    private URL photoPath;

}