package com.epam.javaTraining.globoforceTestProject;

/**
 * @author Viachaslau_Kavaliou
 * @version 1.0, 17-DEC-2017
 */

public class Nominator extends Person {
//    private String name;
//    private int nominatorAwardQuantityLimit = 5;
//    private float nominatorAwardAmountLimit = 10000f;
    private int count = 1;


    /**
     * Default constructor is used if award quantity (nominatorAwardQuantityLimit) and award amount limit (nominatorAwardAmountLimit) for nominator are default
     *
     * @param name nominator's name
     */
    public Nominator(String name) {
        super(name);
        getNominatorParams();
    }

    /**
     * Used if award quantity (nominatorAwardQuantityLimit) and award amount limit (nominatorAwardAmountLimit) for nominator are set by user
     *
     * @param name                        nominator's name
     * @param nominatorAwardAmountLimit   award amount limit for nominator
     * @param nominatorAwardQuantityLimit award quantity limit for nominator (how many award can be given by nominator)
     */
    public Nominator(String name, int nominatorAwardQuantityLimit, float nominatorAwardAmountLimit) {
        super(name,nominatorAwardQuantityLimit,nominatorAwardAmountLimit);
        getNominatorParams();
    }

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

    private int getCount() {
        return count;
    }

    private void setCount(int count) {
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



    public void nominate(Award award, Nominee nominee) {
        System.out.println("---------------Attempt to give award # " + getCount() + " by nominator " + getName() + " ---------------");
        System.out.println(isEligible(award.getValue(),getAwardQuantityLimit(),getAwardQuantityLimit()));
        System.out.println(nominee.canBeNominated(award));
        //if (getNominatorAwardQuantityLimit() > 0 && getNominatorAwardAmountLimit() >= award.getValue() && nominee.canBeNominated(award)) {
        if (isEligible(award.getValue(), getAwardQuantityLimit(),getAwardAmountLimit()) == true && isEligible(award.getValue(),nominee.getAwardQuantityLimit(),nominee.getAwardAmountLimit()) == true) {
            nominee.receiveAward(award);
            setAwardQuantityLimit(getAwardQuantityLimit() - 1);
            setAwardAmountLimit(getAwardAmountLimit() - award.getValue());
            printRestOfAwards();
            printBalance();
        } else if (getAwardQuantityLimit() > 0 && getAwardAmountLimit() < award.getValue()) {
            System.out.println("It's impossible to create an award that has value " + award.getValue() + " USD (more than nominator's balance)");
            System.out.println("================================================");
        } else if (getAwardQuantityLimit() <= 0 && getAwardAmountLimit() >= award.getValue()) {
            System.out.println("Regardless nominator's balance allows to give awards, he has already reached his own limit of awards.");
        } else {
            System.out.println(this.getName() + " hasn't been able to give any awards yet");
        }
        setCount(getCount() + 1);
    }

    /**
     * Method 'printRestOfAwards' displays information message how many awards nominator is able to give after the last successful placement an award
     */
    private void printRestOfAwards() {
        System.out.println(this.getName() + " is able to give " + getAwardQuantityLimit() + " awards");
    }

    /**
     * Method 'printBalance' displays information message about nominator's balance (amount that the nominator is able to use for giving awards)
     */
    private void printBalance() {
        System.out.println("Balance is " + getAwardAmountLimit() + " USD");
        System.out.println("================================================");
    }
}

