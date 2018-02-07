package com.epam.training.recognition.entity;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Viachaslau_Kavaliou
 * @version 1.0, 17-DEC-2017
 */
public class Nominee extends Person {
    private final double c;
    private final int z;
    private ArrayList<Award> allAwards = new ArrayList<Award>();
    private ArrayList<Award> awardsWitoutSoli = new ArrayList<Award>();
    private int awardAmountLimit = 10000;


    {
        Random rand = new Random();
        c = rand.nextInt(5) + rand.nextDouble();
        z = rand.nextInt(10);
    }

    /**
     * This constructor is used if award quantity and award amount limits for nominator are default for nominee (award amount limit has specific default value for nominees)
     *
     * @param name nominee's name
     */
    public Nominee(String name) {
        super(name);
    }

    /**
     * @param name                      nominee's name
     * @param nomineeAwardAmountLimit   award amount limit for nominee
     * @param nomineeAwardQuantityLimit award quantity limit for nominee (how many award can be received by nominee)
     */

    public Nominee(String name, int awardQuantityLimit, int awardAmountLimit) {
        super(name, awardQuantityLimit);
        this.awardAmountLimit = awardAmountLimit;
    }

    public double getC() {
        return c;
    }

    public int getZ() {
        return z;
    }

    public ArrayList<Award> getAllAwards() {
        return allAwards;
    }


    public ArrayList<Award> getAwardsWitoutSoli() {
        return awardsWitoutSoli;
    }


    public int getAwardAmountLimit() {
        return awardAmountLimit;
    }

    public void setAwardAmountLimit(int awardAmountLimit) {
        this.awardAmountLimit = awardAmountLimit;
    }

    /**
     * The method is overloaded -> added additional condition that checks if nominee's balance allows him to receive award with this value
     * @param value award value
     * @return return true if nominee hasn't reached limit by his quantitiy limit (>0) and his balance allows to receive award with this value
     */
    public boolean isEligible(int value) {
        return getAwardQuantityLimit() > 0 && getAwardAmountLimit() >= value;
    }
}

