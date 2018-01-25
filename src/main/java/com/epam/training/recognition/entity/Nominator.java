package com.epam.training.recognition.entity;

import com.epam.training.recognition.view.Runner;

/**
 * @author Viachaslau_Kavaliou
 * @version 1.0, 17-DEC-2017
 */

public class Nominator extends Person {
//    private int nominatorAwardQuantityLimit = 5;
//    private float nominatorAwardAmountLimit = 10000f;
    private int count = 1;


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
     * @param name                        nominator's name
     * @param nominatorAwardAmountLimit   award amount limit for nominator
     * @param nominatorAwardQuantityLimit award quantity limit for nominator
     */
    public Nominator(String name, int awardQuantityLimit, float awardAmountLimit) {
        super(name, awardQuantityLimit, awardAmountLimit);
    }

    /**
     * Method getAwardQuantityLimit is overridden due to specific default award quantity limit set for nominators
     * @return returns award quantity limit for nominator (default value is used from Nominator class in case if it's not set by user)
//     */
//    @Override
//    public int getAwardQuantityLimit() {
//        return nominatorAwardQuantityLimit;
//    }
//
//    /**
//     * Method setAwardQuantityLimit is overridden due to specific default award quantity limit set for nominators
//     * @param nominatorAwardQuantityLimit award quantity limit for nominator
//     */
//    @Override
//    public void setAwardQuantityLimit(int nominatorAwardQuantityLimit) {
//        this.nominatorAwardQuantityLimit = nominatorAwardQuantityLimit;
//    }

//    public Nominator(String name, float nominatorAwardAmountLimit, int nominatorAwardQuantityLimit) {
//        this.name = name;
//        setNominatorAwardAmountLimit(nominatorAwardAmountLimit);
//        setNominatorAwardQuantityLimit(nominatorAwardQuantityLimit);
//        getNominatorParams();
//    }
//
//    public Nominator(String name) {
//        this(name,1000,5);
//    }

//    public float setNominatorAwardAmountLimit(float nominatorAwardAmountLimit) {
//        if (nominatorAwardAmountLimit == 0) {
//            return 1000f;
//        }
//        this.nominatorAwardAmountLimit = nominatorAwardAmountLimit;
//        return nominatorAwardAmountLimit;
//    }
//
//    public int setNominatorAwardQuantityLimit(int nominatorAwardQuantityLimit) {
//        if (nominatorAwardQuantityLimit == 0) {
//            return 5;
//        }
//        this.nominatorAwardQuantityLimit = nominatorAwardQuantityLimit;
//        return nominatorAwardQuantityLimit;
//    }

    /**
     * @return displays nominator's input parameters
     */
    @Override
    public String toString() {
        return "Nominator{" +
                "name='" + getName() + '\'' +
                ", nominatorAwardQuantityLimit=" + getAwardQuantityLimit() +
                ", nominatorAwardAmountLimit=" + getAwardAmountLimit() +
                '}';
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void getNominatorParams() {
        System.out.println("------------------------------------------------------------------------");
        System.out.println(this.toString());
    }

    /**
     * Method 'nominate' defines whether nominator is able to give an award or not according to his own award quantity (nominatorAwardQuantityLimit) and award amount limit (nominatorAwardAmountLimit).
     * Every successfully given award reduces this limit.
     * If award value is higher than nominator's balance but nominator is still able to give awards, appropriate message is displayed.
     * If award value is less than nominator's balance but nominator isn't able to give any awards, the message that nominator has already reached his own limit of awards is displayed.
     * If nominator's balance is less than award value and nominator isn't able to give any awards, the message that nominator hasn't been able to give any awards yet is displayed.
     *
     * @param award   - award that nominator is going to give to nominee
     * @param nominee - nominee whom nominator wants to recognize
     */

//    public boolean isNomineeEligible (Award award) {
//        return (isEligible(award.getValue(), getAwardQuantityLimit(), getAwardAmountLimit()));
//    }


//    public void nominate(Award award, Nominee nominee) {
//        System.out.println("---------------Attempt to give award # " + getCount() + " by nominator " + getName() + " ---------------");
//        System.out.println(isEligible(award.getValue(),getAwardQuantityLimit(),getAwardQuantityLimit()));
//        System.out.println(nominee.canBeNominated(award));
//        //if (getNominatorAwardQuantityLimit() > 0 && getNominatorAwardAmountLimit() >= award.getValue() && nominee.canBeNominated(award)) {
//        if (super.isEligible(award.getValue(), getAwardQuantityLimit(),getAwardAmountLimit()) == true && isEligible(award.getValue(),nominee.getAwardQuantityLimit(),nominee.getAwardAmountLimit()) == true) {
//            nominee.receiveAward(award);
//            setAwardQuantityLimit(getAwardQuantityLimit() - 1);
//            setAwardAmountLimit(getAwardAmountLimit() - award.getValue());
//            printRestOfAwards();
//            printBalance();
//        } else if (getAwardQuantityLimit() > 0 && getAwardAmountLimit() < award.getValue()) {
//            System.out.println("It's impossible to create an award that has value " + award.getValue() + " USD (more than nominator's balance)");
//            System.out.println("================================================");
//        } else if (getAwardQuantityLimit() <= 0 && getAwardAmountLimit() >= award.getValue()) {
//            System.out.println("Regardless nominator's balance allows to give awards, he has already reached his own limit of awards.");
//        } else {
//            System.out.println(this.getName() + " hasn't been able to give any awards yet");
//        }
//        setCount(getCount() + 1);
//    }

    /**
     * Method 'printRestOfAwards' displays information message how many awards nominator is able to give after the last successful placement an award
     */



    public void printRestOfAwards() {
        System.out.println(this.getName() + " is able to give " + getAwardQuantityLimit() + " awards");
    }


    /**
     * Method 'printBalance' displays information message about nominator's balance (amount that the nominator is able to use for giving awards)
     */
//    public void printBalance() {
//        System.out.println("Balance is " + getAwardAmountLimit() + " USD");
//        System.out.println("================================================");
//    }
}

