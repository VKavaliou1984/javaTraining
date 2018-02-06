package com.epam.training.recognition.entity;

import java.awt.*;

public abstract class Person implements OperationsWithLimit {
    protected String name;
    private int awardQuantityLimit = 10;
    private int awardAmountLimit = 2000;


    public Person () {}


    public Person(String name, int awardQuantityLimit, int awardAmountLimit) {
        this(name);
        this.awardQuantityLimit = awardQuantityLimit;
        this.awardAmountLimit = awardAmountLimit;
    }

    public Person(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAwardQuantityLimit() {
        return awardQuantityLimit;
    }

    public void setAwardQuantityLimit(int awardQuantityLimit) {
        this.awardQuantityLimit = awardQuantityLimit;
    }

    public int getAwardAmountLimit() {
        return awardAmountLimit;
    }

    public void setAwardAmountLimit(int awardAmountLimit) {
        this.awardAmountLimit = awardAmountLimit;
    }


    public boolean isEligible(int value) {
        return getAwardQuantityLimit() > 0 && getAwardAmountLimit() >= value;
    }
}
