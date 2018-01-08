package com.epam.javaTraining.globoforceTestProject;

/**
 * @author Viachaslau_Kavaliou
 * @version 1.0, 17-DEC-2017
 */

public class Nominator {
    private String name;
    private int nominatorAwardQuantityLimit = 5;
    private float nominatorAwardAmountLimit = 1000f;
    private int count = 1;


    /**
     * Default constructor is used if award quantity (nominatorAwardQuantityLimit) and award amount limit (nominatorAwardAmountLimit) for nominator are default
     *
     * @param name nominator's name
     */
    public Nominator(String name) {
        this.name = name;
        getNominatorParams();
    }

    /**
     * Used if award quantity (nominatorAwardQuantityLimit) and award amount limit (nominatorAwardAmountLimit) for nominator are set by user
     * @param name nominator's name
     * @param nominatorAwardAmountLimit award amount limit for nominator
     * @param nominatorAwardQuantityLimit award quantity limit for nominator (how many award can be given by nominator)
     */
    public Nominator(String name, float nominatorAwardAmountLimit, int nominatorAwardQuantityLimit) {
        this.name = name;
        this.nominatorAwardAmountLimit = nominatorAwardAmountLimit;
        this.nominatorAwardQuantityLimit = nominatorAwardQuantityLimit;
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
     *
     * @return displays nominator's input parameters
     */
    @Override
    public String toString() {
        return "Nominator{" +
                "name='" + name + '\'' +
                ", nominatorAwardQuantityLimit=" + nominatorAwardQuantityLimit +
                ", nominatorAwardAmountLimit=" + nominatorAwardAmountLimit +
                '}';
    }

    public String getName() {
        return name;
    }

//    public int getNominatorAwardQuantityLimit() {
//        return nominatorAwardQuantityLimit;
//    }

//    public void setNominatorAwardQuantityLimit(int nominatorAwardQuantityLimit) {
//        this.nominatorAwardQuantityLimit = nominatorAwardQuantityLimit;
//    }

//    public float getNominatorAwardAmountLimit() {
//        return nominatorAwardAmountLimit;
//    }
//
//    public void setNominatorAwardAmountLimit(int nominatorAwardAmountLimit) {
//        this.nominatorAwardAmountLimit = nominatorAwardAmountLimit;
//    }

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
     * @param award   - award that nominator is going to give to nominee
     * @param nominee - nominee whom nominator wants to recognize
     */
    public void nominate(Award award, Nominee nominee) {
        System.out.println("---------------Attempt to give award # " + count + " by nominator " + getName() + " ---------------");
        System.out.println(nominee.canBeNominated(award));
        if (nominatorAwardQuantityLimit > 0 && nominatorAwardAmountLimit >= award.getValue() && nominee.canBeNominated(award)) {
            nominee.receiveAward(award);
            nominatorAwardQuantityLimit--;
            nominatorAwardAmountLimit -= award.getValue();
            printRestOfAwards();
            printBalance();
        } else if (nominatorAwardQuantityLimit > 0 && nominatorAwardAmountLimit < award.getValue()) {
            System.out.println("It's impossible to create an award that has value " + award.getValue() + " USD (more than nominator's balance)");
            System.out.println("================================================");
        } else if (nominatorAwardQuantityLimit <= 0 && nominatorAwardAmountLimit >= award.getValue()) {
            System.out.println("Regardless nominator's balance allows to give awards, he has already reached his own limit of awards.");
        } else {
            System.out.println(this.getName() + " hasn't been able to give any awards yet");
        }
        count++;
    }

    /**
     * Method 'printRestOfAwards' displays information message how many awards nominator is able to give after the last successful placement an award
     */
    private void printRestOfAwards() {
        System.out.println(this.getName() + " is able to give " + nominatorAwardQuantityLimit + " awards");
    }

    /**
     * Method 'printBalance' displays information message about nominator's balance (amount that the nominator is able to use for giving awards)
     */
    private void printBalance() {
        System.out.println("Balance is " + nominatorAwardAmountLimit + " USD");
        System.out.println("================================================");
    }
}

