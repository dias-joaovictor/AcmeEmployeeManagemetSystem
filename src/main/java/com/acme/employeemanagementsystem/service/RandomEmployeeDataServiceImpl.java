package com.acme.employeemanagementsystem.service;

import com.acme.employeemanagementsystem.model.Address;
import com.acme.employeemanagementsystem.model.Department;
import com.acme.employeemanagementsystem.model.Level;
import com.acme.employeemanagementsystem.model.PhoneNumber;
import com.acme.employeemanagementsystem.model.PhoneType;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class RandomEmployeeDataServiceImpl implements RandomEmployeeDataService {

    protected final RandomService randomService;

    protected final FakerService fakerService;


    @Override
    public String getName() {
        return getFaker().name().fullName();
    }

    @Override
    public List<PhoneNumber> getPhoneNumbers() {
        var amountOfNumbers = randomService.getInt(1, 5);

        List<PhoneNumber> phoneNumbers = new ArrayList<>(amountOfNumbers);
        for(int i = 0; i < amountOfNumbers; i++){
            var numberType = randomService.getInt(1, 3);
            phoneNumbers.add(PhoneNumber.builder()
                    .number(this.getFaker().phoneNumber().phoneNumber())
                    .phoneType(numberType == 1 ? PhoneType.LANDLINE : PhoneType.MOBILE)
                .build());
        }

        return phoneNumbers;
    }

    @Override
    public Address getAddress() {
        return Address.builder()
            .country(getFaker().country().countryCode2())
            .postalCode(getFaker().address().zipCode())
            .streetName(getFaker().address().streetName())
            .houseNumber(getFaker().address().streetAddressNumber())
            .build();
    }

    @Override
    public BigDecimal getSalary() {
        return randomService.getBigDecimal(1000, 25000);
    }

    @Override
    public Department getDepartment() {
        var numberType = randomService.getInt(1, 4);

        return switch (numberType) {
            case 1 -> Department.DEVELOPMENT;
            case 2 -> Department.DEVOPS;
            default -> Department.DATABASE;
        };
    }

    @Override
    public Level getLevel() {
        var numberType = randomService.getInt(1, 5);

        return switch (numberType) {
            case 1 -> Level.INTERN;
            case 2 -> Level.JUNIOR;
            case 3 -> Level.MIDLEVEL;
            default -> Level.SENIOR;
        };
    }

    protected Faker getFaker() {
        return fakerService.getFaker();
    }

}
