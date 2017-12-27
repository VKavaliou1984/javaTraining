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
        if (nominatorAwardQuantityLimit > 0 && nominatorAwardAmountLimit > award.getValue()) {
            nominee.receiveAward(award);
            printRestOfAwards();
            nominatorAwardQuantityLimit--;
            nominatorAwardAmountLimit -= award.getValue();
            printBalance();
        }
        else if (nominatorAwardQuantityLimit > 0 && nominatorAwardAmountLimit < award.getValue()) {
            System.out.println("It's impossible to create an award that has value " + award.getValue() + " USD (more than nominator's balance)");
        }
        else {
            System.out.println(this.getName() + " hasn't been able to give any awards yet");
        }

//        nominatorBalance -= award.getValue();
//        System.out.println(this.name + " has balance " + nominatorBalance);
//
//        if (restOfAwards <= 0) {
//            System.out.println("Nominator " + this.name + " hasn't been able to give any awards yet.");
//        } else if (nominatorBalance <= 0) {
//            System.out.println("Nominator has reached limit of awards amount");
//        }
    }

//    public int canNominate() {
//        System.out.println("nominatorAwardQuantityLimit " + nominatorAwardQuantityLimit);
//        for (Award awardNominator : arrayAwards) {
//            if (nominatorAwardQuantityLimit >= arrayAwards.size()) ;
//            {
//                nominatorAwardQuantityLimit--;
////                System.out.println(arrayAwards.size() + " awards are created");
////                System.out.println(awardNominator.getValue());
////                System.out.println(nominatorAwardQuantityLimit + "awards can be given by nominator");
//            }
//            System.out.println("");
//        }
//        return nominatorAwardQuantityLimit;
//    }

    private void printRestOfAwards() {
        System.out.println(this.getName() + " is able to give " + nominatorAwardQuantityLimit + " awards");
    }

    private void printBalance() {
        System.out.println("Balance is " + nominatorAwardAmountLimit + " USD");
        System.out.println("================================================");
    }

    public void nominate1(Award award, Nominee nominee) {
        nominee.receiveAward1(award);
    }
}

