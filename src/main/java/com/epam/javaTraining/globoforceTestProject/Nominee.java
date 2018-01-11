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
    private final double c;
    private final int z;
    private ArrayList<Award> array = new ArrayList<Award>();

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
     * @param name                      nominee's name
     * @param nomineeAwardAmountLimit   award amount limit for nominee
     * @param nomineeAwardQuantityLimit award quantity limit for nominee (how many award can be received by nominee)
     */
    public Nominee(String name, float nomineeAwardAmountLimit, int nomineeAwardQuantityLimit) {
        this.setName(name);
        this.setNomineeAwardAmountLimit(nomineeAwardAmountLimit);
        this.setNomineeAwardQuantityLimit(nomineeAwardQuantityLimit);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
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
     * If award has soli, quantity indicator is calculated by formula in NominationHelper utility class
     *
     * @param award award that nominator is intending to give to nominee
     */
    public void receiveAward(Award award) {
        switch (getNomineeAwardQuantityLimit()) {
            case 0:
                System.out.println(this.getName() + " isn't able to receive any awards");
                break;
            case 1:
                System.out.println(this.getName() + " is able to receive only 1 award");
                break;
            default:
                System.out.println(this.getName() + " is able to receive " + getNomineeAwardQuantityLimit() + " awards");
                break;
        }
        if (getNomineeAwardQuantityLimit() > 0 && getNomineeAwardAmountLimit() >= award.getValue()) {
            array.add(award);
            if (award.getSoli() > 0) {
                System.out.println("Nominee is " + getName() + "\n" + "Nominee's balance is " + getNomineeAwardAmountLimit() + "\n" + "Due to SOLI index, the actual amount of the award is " + award.getSoli() + " USD. It is " + award.getSoli() / award.getValue() * 100 + "% of the award amount.");
            } else {
                System.out.println("Nominee is " + getName() + "\n" + "Nominee's balance is " + getNomineeAwardAmountLimit() + "\n" + "SOLI index isn't applied for this award. The actual amount of the award is " + award.getValue() + " USD.");
                System.out.println("Quantity = " + NominationHelper.getQuantity(award.getValue(), z, c, NominationHelper.getPopulation(array)));
            }
            setNomineeAwardAmountLimit(getNomineeAwardAmountLimit() - award.getValue());
            setNomineeAwardQuantityLimit(getNomineeAwardQuantityLimit() - 1);
        } else if (getNomineeAwardQuantityLimit() > 0 && getNomineeAwardAmountLimit() < award.getValue()) {
            System.out.println("It's impossible to create an award that has value " + award.getValue() + " USD (more than nominee's balance)");
        } else {
            System.out.println("Award wasn't created due to reaching limit for the recipient");
        }
    }

    /**
     * Method 'canBeNominated' defines whether nominee is able to receive the award or not
     *
     * @param award award that nominator is going to five to nominee
     * @return true if nominee's balance is higher than award value and award quantity limit
     */
    public boolean canBeNominated(Award award) {
        if (getNomineeAwardQuantityLimit() > 0 && getNomineeAwardAmountLimit() >= award.getValue()) {
            return true;
        }
        return false;
    }
}

