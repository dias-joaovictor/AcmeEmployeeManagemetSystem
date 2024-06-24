package com.acme.employeemanagementsystem.service;

import java.math.BigDecimal;

public interface RandomService {
    int getInt(int startInclusive, int endExclusive);

    BigDecimal getBigDecimal(double startInclusive, double endExclusive);
}
