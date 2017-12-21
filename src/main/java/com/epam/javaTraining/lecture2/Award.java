package com.epam.javaTraining.lecture2;

/**
 * Created by Viachaslau_Kavaliou on 17/12/2017.
 */
public class Award {
    private final int value;
    private float soli;
    private float loss;

    public Award(Integer value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setSoli(float soli) {
        this.soli = soli;
    }

    public float getSoli() {
        return soli;
    }

    static {
        System.out.println("Award class");
    }
}

