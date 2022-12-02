package com.github.timurnabiyev.postgresql_course.models;

import lombok.*;

import java.net.URL;
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Suppliers {
    private Integer supplierId;
    private String companyName;
    private String contactName;
    private String contactTitle;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String phone;
    private String fax;
    private URL homePage;

}