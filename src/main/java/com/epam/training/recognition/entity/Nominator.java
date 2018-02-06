package com.epam.training.recognition.entity;

/**
 * @author Viachaslau_Kavaliou
 * @version 1.0, 17-DEC-2017
 */

public class Nominator extends Person {
    public String firstName;
    public String lastName;


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
        super(name, awardQuantityLimit, awardAmountLimit);
    }

    public Nominator (String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String setName (String firstName, String lastName) {
        return firstName + lastName;
    }
}

