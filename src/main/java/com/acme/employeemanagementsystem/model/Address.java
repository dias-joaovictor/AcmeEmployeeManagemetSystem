package com.acme.employeemanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Address {

    private String country;

    private String postalCode;

    private String streetName;

    private String houseNumber;

    private String complement;

}
