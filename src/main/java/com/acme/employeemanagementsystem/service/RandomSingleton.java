package com.acme.employeemanagementsystem.service;


import java.math.BigDecimal;
import java.util.Random;

public final class RandomSingleton implements RandomService {

    private static RandomSingleton instance;

    private final Random random;

    private RandomSingleton(Random random) {
        this.random = random;
    }

    public static RandomSingleton getInstance() {
        if(instance == null){
            instance = new RandomSingleton(new Random());
        }
        return instance;
    }

    @Override
    public int getInt(int startInclusive, int endExclusive) {
        return random.nextInt(startInclusive, endExclusive);
    }

    @Override
    public BigDecimal getBigDecimal(double startInclusive, double endExclusive){
        return BigDecimal.valueOf(random.nextDouble(startInclusive, endExclusive));
    }

}
