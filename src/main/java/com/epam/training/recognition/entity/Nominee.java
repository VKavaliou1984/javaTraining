package com.epam.training.recognition.entity;

import com.epam.training.recognition.service.NominationHelper;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Viachaslau_Kavaliou
 * @version 1.0, 17-DEC-2017
 */
public class Nominee extends Person {
//    private String name;
//    private int nomineeAwardQuantityLimit = 5;
//    private float nomineeAwardAmountLimit = 1000f;
//    private static final int NOMINEE_AWARD_AMOUNT_LIMIT = 10;
//    private static final int NOMINEE_AWARD_QUANTITY_LIMIT = 10;

    String value;
    private final double c;
    private final int z;
    public ArrayList<Award> array = new ArrayList<Award>();

    static {
        String value = String.format("Hello  from Nominee  class", "some1", "test2");
        System.out.println(value);
    }

    {
        Random rand = new Random();
        c = rand.nextInt(5) + rand.nextDouble();
        z = rand.nextInt(10);
    }

    public double getC() {
        return c;
    }

    public int getZ() {
        return z;
    }

    /**
     * This constructor is used if award quantity and award amount limits for nominator are default for nominee (award amount limit has specific default value for nominees)
     * @param name nominee's name
     */
    public Nominee (String name) {
        super(name);
    }

    /**
     * @param name                      nominee's name
     * @param nomineeAwardAmountLimit   award amount limit for nominee
     * @param nomineeAwardQuantityLimit award quantity limit for nominee (how many award can be received by nominee)
     */

    public Nominee(String name, int nomineeAwardQuantityLimit, float nomineeAwardAmountLimit) {
        super(name, nomineeAwardQuantityLimit, nomineeAwardAmountLimit);
    }

    /**
     * Method 'recieveAward' defines whether nominee is able to receive an award or not according to his own award quantity (nomineeAwardQuantityLimit) and award amount limit (nomineeAwardAmountLimit).
     * Every successfully received award reduces this limit.
     * If award doesn't have soli, appropriate message displays
     * If award has soli, quantity indicator is calculated by formula in NominationHelper utility class
     *
     * @param award award that nominator is intending to give to nominee
     */
//    public void receiveAward(Award award) {
//        if (isEligible(award.getValue(), getAwardQuantityLimit(), getAwardAmountLimit())) {
//            array.add(award);
//            setAwardAmountLimit(getAwardAmountLimit() - award.getValue());
//            setAwardQuantityLimit(getAwardQuantityLimit() - 1);
//        } else if (getAwardQuantityLimit() > 0 && getAwardAmountLimit() < award.getValue()) {
//            System.out.println("It's impossible to create an award that has value " + award.getValue() + " USD (more than nominee's balance)");
//        } else {
//            System.out.println("Award wasn't created due to reaching limit for the recipient");
//        }
//    }


    public double calculateSoli(Award award) {
        return (award.getSoli() < 0) ? NominationHelper.getQuantity(array,award.getValue(), z, c) : 0;
    }

    public void showAwardQuantityLimit() {
        switch (getAwardQuantityLimit()) {
            case 0:
                System.out.println(this.getName() + " isn't able to receive any awards");
                break;
            case 1:
                System.out.println(this.getName() + " is able to receive only 1 award");
                break;
            default:
                System.out.println(this.getName() + " is able to receive " + getAwardQuantityLimit() + " awards");
                break;
        }
    }
    /**
     * Method 'canBeNominated' defines whether nominee is able to receive the award or not
     *
     * @param award award that nominator is going to five to nominee
     * @return true if nominee's balance is higher than award value and award quantity limit
     */
    public boolean canBeNominated(Award award) {
        return getAwardQuantityLimit() > 0 && getAwardAmountLimit() >= award.getValue();
    }
}

