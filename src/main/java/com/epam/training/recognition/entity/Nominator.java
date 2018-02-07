package com.epam.training.recognition.entity;

/**
 * @author Viachaslau_Kavaliou
 * @version 1.0, 17-DEC-2017
 */

public class Nominator extends Person {

    private int awardAmountLimit = 5000;
    /**
     * This constructor is used if award quantity and award amount limits for nominator are default for nominee (award quantity limit has specific default value for nominators)
     *
     * @param name nominator's name
     */
    public Nominator(String name) {
        super(name);
    }

    /**
     * Used if award quantity (nominatorAwardQuantityLimit) and award amount (nominatorAwardAmountLimit) limits for nominator are set by user
     *
     * @param name               nominator's name
     * @param awardAmountLimit   award amount limit for nominator
     * @param awardQuantityLimit award quantity limit for nominator
     */
    public Nominator(String name, int awardQuantityLimit, int awardAmountLimit) {
        super(name, awardQuantityLimit);
        this.awardAmountLimit = awardAmountLimit;
    }

    public int getAwardAmountLimit() {
        return awardAmountLimit;
    }

    public void setAwardAmountLimit(int awardAmountLimit) {
        this.awardAmountLimit = awardAmountLimit;
    }


    /**
     * The method is overloaded -> added additional condition that checks if nominator's balance allows him to give award with this value
     * @param value award value
     * @return return true if nominator hasn't reached limit by his quantitiy limit (>0) and his balance allows to give award with this value
     */
    public boolean isEligible(int value) {
        return getAwardQuantityLimit() > 0 && getAwardAmountLimit() >= value;
    }

    /**
     * Standard method toString is overridden to print information about nominator in more appropriate form
     * @return return information about nominator's name
     */

    @Override
    public String toString () {
        return "Nominator=" + getName();
    }

}

