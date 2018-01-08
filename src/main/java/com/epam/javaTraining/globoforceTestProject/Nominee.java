package com.epam.javaTraining.globoforceTestProject;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Viachaslau_Kavaliou
 * @version 1.0, 17-DEC-2017
 */
public class Nominee {
    private String name;
    private int nomineeAwardQuantityLimit = 5;
    private float nomineeAwardAmountLimit = 1000f;
    private ArrayList<Award> array = new ArrayList<Award>();
    private final double c;
    private final int z;

    static {
          String value = String.format("Hello from Nominee class");
                System.out.println(value);
    }

    {
        Random rand = new Random();
        c = rand.nextInt(5) + rand.nextDouble();
        z = rand.nextInt(10);
    }

    /**
     *
     * @param name nominee's name
     * @param nomineeAwardAmountLimit award amount limit for nominee
     * @param nomineeAwardQuantityLimit award quantity limit for nominee (how many award can be received by nominee)
     */
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

    /**
     * Method 'recieveAward' defines whether nominee is able to receive an award or not according to his own award quantity (nomineeAwardQuantityLimit) and award amount limit (nomineeAwardAmountLimit).
     * Every successfully received award reduces this limit.
     * If award doesn't have soli, appropriate message displays
     * If award has soli, quantity indicator is calculated:
     * quantity = ((Z^2*(P)*(1-P))/(C^2)) / (1 + ((((Z^2*(P)*(1-P ))/(C^2))-1)/population))
     * where:
     * C = a random decimal
     * population = total count of employee's awards without soli
     * Z = a random whole number
     * P = award value
     * -----------------------
     * If any of nominee's limits (award quantity or award amount) doesn't allow to receive an award, appropriate error message displays
     * @param award award that nominator is going to give to nominee
     */
    public void receiveAward(Award award) {
        switch (nomineeAwardQuantityLimit) {
            case 0:
                System.out.println(this.getName() + " isn't able to receive any awards");
                break;
            case 1:
                System.out.println(this.getName() + " is able to receive only 1 award");
                break;
            default:
                System.out.println(this.getName() + " is able to receive " + nomineeAwardQuantityLimit + " awards");
                break;
        }
        if (nomineeAwardQuantityLimit > 0 && nomineeAwardAmountLimit >= award.getValue()) {
            array.add(award);
            int population = getPopulation();
            double quantity = 0, x = 0;
            if (award.getSoli() > 0) {
                System.out.println("Nominee is " + name + "\n" + "Nominee's balance is " + nomineeAwardAmountLimit + "\n" + "Due to SOLI index, the actual amount of the award is " + award.getSoli() + " USD. It is " + award.getSoli() / award.getValue() * 100 + "% of the award amount.");
            } else {
                System.out.println("Nominee is " + name + "\n" + "Nominee's balance is " + nomineeAwardAmountLimit + "\n" + "SOLI index isn't applied for this award. The actual amount of the award is " + award.getValue() + " USD.");
                x = ((z * z * award.getValue()) * (1 - award.getValue())) / (population);
                quantity = x / ((1 + ((x - 1) / population)));
                System.out.println("Quantity = " + quantity);
                System.out.println("FYI: x=" + x + ", c=" + c + ", z=" + z + " " + population);
            }
            nomineeAwardAmountLimit -= award.getValue();
            nomineeAwardQuantityLimit--;
        } else if (nomineeAwardQuantityLimit > 0 && nomineeAwardAmountLimit < award.getValue()) {
            System.out.println("It's impossible to create an award that has value " + award.getValue() + " USD (more than nominee's balance)");
        } else {
            System.out.println("Award wasn't created due to reaching limit for the recipient");
        }
    }

    /**
     * Method "getPopulation" calculated amount of awards without soli after each successfully given award for the nominee
     * @return  amount of awards without soli
     */
    private int getPopulation() {
        int population = 0;
        for (Award award : array) {

            if (award.getSoli() <= 0) {
                population++;
            }
        }
        return population;
    }

//    private int getRestOfNomineesAwards() {
//        int restOfAwards = this.nomineeAwardQuantityLimit;
//        for (Award award : array) {
//            if (restOfAwards > 0) {
//                restOfAwards--;
//            }
//        }
//        return restOfAwards;
//    }

    /**
     * Method 'canBeNominated' defines whether nominee is able to receive the award or not
     * @param award award that nominator is going to five to nominee
     * @return true if nominee's balance is higher than award value and award quantity limit
     */
    public boolean canBeNominated (Award award) {
        if (nomineeAwardQuantityLimit >0 && nomineeAwardAmountLimit >=award.getValue()) {
            return true;
        }
    return false;
}
}

