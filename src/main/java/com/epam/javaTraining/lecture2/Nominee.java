package com.epam.javaTraining.lecture2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Viachaslau_Kavaliou on 17/12/2017.
 */
public class Nominee {
    private String name;
    private int nomineeAwardQuantityLimit;
    private float nomineeAwardAmountLimit;
    private ArrayList<Award> array = new ArrayList<Award>();
    private final double c;
    private final int z;

    static {
        System.out.println("Hello from Nominee class");
    }

    {
        Random rand = new Random();
        c = rand.nextInt(5) + rand.nextDouble();
        z = rand.nextInt(10);
    }


    public Nominee(String name, float nomineeAwardAmountLimit, int nomineeAwardQuantityLimit) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNomineeAwardQuantityLimit() {
        return nomineeAwardQuantityLimit;
    }


    public void setNomineeAwardQuantityLimit(int nomineeAwardQuantityLimit) {
        this.nomineeAwardQuantityLimit = nomineeAwardQuantityLimit;
    }

    public float getNomineeAwardAmountLimit() {
        return nomineeAwardAmountLimit;
    }

    public void setNomineeAwardAmountLimit(float nomineeAwardAmountLimit) {
        this.nomineeAwardAmountLimit = nomineeAwardAmountLimit;
    }

    public void receiveAward(Award award) {
        array.add(award);
        int population = getPopulation();
        double quantity = 0,x=0;
        if (award.getSoli() > 0) {
            System.out.println("Nominee is " + name + ". Due to SOLI index, the actual amount of the award is " + award.getSoli() + " USD. It is " + award.getSoli() / award.getValue() * 100 + "% of the award amount.");
        } else {
            System.out.println("Nominee is " + name + ". SOLI index isn't applied for this award. The actual amount of the award is " + award.getValue() + " USD.");
            x = ((z * z * award.getValue()) * (1 - award.getValue())) / (population);
            quantity = x / ((1 + ((x - 1) / population)));
            System.out.println("Quantity = " + quantity);
            System.out.println("FYI: x=" + x + ", c=" + c + ", z=" + z + " " + population);
        }
    }

    private int getPopulation() {
        int population = 0;
        for (Award award : array) {
            if (award.getSoli() <= 0) {
                population++;
            }
        }
        return population;
    }

    public void receiveAward1(Award award) {
    }
}

