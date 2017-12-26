package com.epam.javaTraining.lecture2;

/**
 * Created by Viachaslau_Kavaliou on 17/12/2017.
 */
public class Nominator {
    private String name;
    private int nominatorAwardQuantityLimit;
    private float nominatorAwardAmountLimit;

    static {
        System.out.println("Hello from Nominator class");
    }

    public Nominator(String name, float nominatorAwardAmountLimit, int nominatorAwardQuantityLimit) {
        this.name = name;
        this.nominatorAwardAmountLimit = nominatorAwardAmountLimit;
        this.nominatorAwardQuantityLimit = nominatorAwardQuantityLimit;
    }

    public String getName() {
        return name;
    }

    public int getNominatorAwardQuantityLimit() {
        return nominatorAwardQuantityLimit;
    }

    public void setNominatorAwardQuantityLimit(int nominatorAwardQuantityLimit) {
        this.nominatorAwardQuantityLimit = nominatorAwardQuantityLimit;
    }

    public float getNominatorAwardAmountLimit() {
        return nominatorAwardAmountLimit;
    }

    public void setNominatorAwardAmountLimit(int nominatorAwardAmountLimit) {
        this.nominatorAwardAmountLimit = nominatorAwardAmountLimit;
    }

    public void nominate(Award award, Nominee nominee) {
        float nominatorAwardsAmount = 0;
        System.out.println("Nominator is " + this.name + ". Max award value is " + this.nominatorAwardAmountLimit + ". Limit of awards is " + this.nominatorAwardQuantityLimit + " items");
//        while (this.nominatorAwardAmountLimit < nominatorAwardsAmount) {
//            nominee.receiveAward(award);
//            nominatorAwardsAmount = nominatorAwardsAmount + award.getValue();
//        }
//        if (this.getNominatorAwardAmountLimit() < award.getValue()) {
//            System.out.println("Nominator isn't able to give an award = " + award.getValue());
//            System.out.println(this.getNominatorAwardAmountLimit());
//        } else if (this.get)
//
//        else {
            nominee.receiveAward(award);
//        }
    }
}

