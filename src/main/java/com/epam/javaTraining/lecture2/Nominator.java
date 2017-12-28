package com.epam.javaTraining.lecture2;

import java.util.ArrayList;

/**
 * Created by Viachaslau_Kavaliou on 17/12/2017.
 */
public class Nominator {
    private String name;
    private int nominatorAwardQuantityLimit;
    private float nominatorAwardAmountLimit;
    private ArrayList<Award> arrayAwards = new ArrayList<Award>();
    private String nominatorName;
    private String nominatorAwardsLimit;
    private String nominatorAmountLimit;
    private int count = 1;


    public Nominator(String name, float nominatorAwardAmountLimit, int nominatorAwardQuantityLimit) {
        this.name = name;
        this.nominatorAwardAmountLimit = nominatorAwardAmountLimit;
        this.nominatorAwardQuantityLimit = nominatorAwardQuantityLimit;
        getNominatorParams();
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

    public void getNominatorParams() {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Nominator is " + this.getName() + ". Max award value is " + this.nominatorAwardAmountLimit + ". Limit of awards is " + this.nominatorAwardQuantityLimit + " items");
        System.out.println("------------------------------------------------------------------------");
    }

    public void nominate(Award award, Nominee nominee) {


        //        int restOfAwards = canNominate();
//        arrayAwards.add(award);
//        double nominatorBalance = this.nominatorAwardAmountLimit;
//            switch (nominatorAwardQuantityLimit) {
//                case 1:
//                    System.out.println(this.getName() + " is able to give only 1 award");
//                    break;
//                default:
//                    System.out.println(this.getName() + " is able to give " + restOfAwards + " awards");
//                    break;
//            }
        System.out.println("---------------Attempt to give award # " + count + " by nominator " + getName() + " ---------------");
        if (nominatorAwardQuantityLimit > 0 && nominatorAwardAmountLimit >= award.getValue()) {
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

    private void printRestOfAwards() {
        System.out.println(this.getName() + " is able to give " + nominatorAwardQuantityLimit + " awards");
    }

    private void printBalance() {
        System.out.println("Balance is " + nominatorAwardAmountLimit + " USD");
        System.out.println("================================================");
    }
}

