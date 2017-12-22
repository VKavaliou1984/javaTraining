package com.epam.javaTraining.lecture2;

/**
 * Created by Viachaslau_Kavaliou on 17/12/2017.
 */
public class Award {
    private final int value;
    private float soli;

 static {
        System.out.println("Hello from Award class");
    }

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

//    public void nomineeAwardsWithoutSoli(Award award, Nominee nominee) {
//        if (award.getSoli() < 1) {
//            counter++;
//        }
//    }
}

