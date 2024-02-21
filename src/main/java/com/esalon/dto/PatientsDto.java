package com.esalon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientsDto {
    private String name;
    private String number;
    private String gender;
    private String dob;
    private String surname;
    private String religion;
    private String nationality;
    private String nationalId;
    private String maritalStatus;
    private String educationLevel;
    private String province;
    private String district;
    private String town;
    private String address;
    private String reportingFacility;
    private String allegies;

}
