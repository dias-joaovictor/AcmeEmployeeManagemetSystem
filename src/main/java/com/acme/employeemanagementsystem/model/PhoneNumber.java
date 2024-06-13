package com.acme.employeemanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PhoneNumber {

    private String countryCode;

    private PhoneType phoneType;

    private String number;
}
