package com.epam.javaTraining.lecture2;

/**
 * Created by Viachaslau_Kavaliou on 17/12/2017.
 */
public class Award {
    private final int value;
    public Award(Integer value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }

    static {
        System.out.println("Award class");
    }
}

