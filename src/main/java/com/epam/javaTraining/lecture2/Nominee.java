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
        this.nomineeAwardAmountLimit = nomineeAwardAmountLimit;
        this.nomineeAwardQuantityLimit = nomineeAwardQuantityLimit;
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
            int restOfAwards = getRestOfNomineesAwards();
            switch (restOfAwards) {
                case 0:
                    System.out.println(this.getName() + " isn't able to receive any awards");
                    break;
                case 1:
                    System.out.println(this.getName() + " is able to receive only 1 award");
                    break;
                default:
                    System.out.println(this.getName() + " is able to receive " + restOfAwards + " awards");
                    break;
            }


            //if (award.getValue() >= this.getNomineeAwardAmountLimit())
            while (restOfAwards > 0) {
                array.add(award);
                int population = getPopulation();
                double quantity = 0, x = 0;
                if (award.getSoli() > 0) {
                    System.out.println("Nominee is " + name + ". Due to SOLI index, the actual amount of the award is " + award.getSoli() + " USD. It is " + award.getSoli() / award.getValue() * 100 + "% of the award amount.");
                } else {
                    System.out.println("Nominee is " + name + ". SOLI index isn't applied for this award. The actual amount of the award is " + award.getValue() + " USD.");
                    x = ((z * z * award.getValue()) * (1 - award.getValue())) / (population);
                    quantity = x / ((1 + ((x - 1) / population)));
                    System.out.println("Quantity = " + quantity);
                    System.out.println("FYI: x=" + x + ", c=" + c + ", z=" + z + " " + population);
                }
                break;
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

    private int getRestOfNomineesAwards (){
        int restOfAwards = this.nomineeAwardQuantityLimit;
        for (Award award: array) {
            restOfAwards--;
        }
    return restOfAwards;
    }



    public void receiveAward1(Award award) {
    }
}

