package com.epam.javaTraining.globoforceTestProject;

public abstract class Person {
    private String name;
    private int awardQuantityLimit = 10;
    private float awardAmountLimit = 2000f;

    public Person(String name, int awardQuantityLimit, float awardAmountLimit) {
        this.name = name;
        this.awardQuantityLimit = awardQuantityLimit;
        this.awardAmountLimit = awardAmountLimit;
    }

    public Person (String name) {
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

    public float getAwardAmountLimit() {
        return awardAmountLimit;
    }

    public void setAwardAmountLimit(float awardAmountLimit) {
        this.awardAmountLimit = awardAmountLimit;
    }

    protected boolean isEligible (int value, int awardQuantityLimit,float awardAmountLimit) {
        if (awardQuantityLimit > 0 && awardAmountLimit > value) {
            return true;
        }
        return false;
    }
}
