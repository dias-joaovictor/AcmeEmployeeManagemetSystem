package com.acme.employeemanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class OutsourcingCompany {

    private String name;

    private Address address;

    @Builder.Default
    private List<PhoneNumber> contacts = new ArrayList<>();
}
