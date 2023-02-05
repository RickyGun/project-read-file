package com.ricky.read_file.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDataResponse {
    private String name;
    private String address;
    private String birthDate;
    private int age;
}
