package com.epam.javaTraining.lecture2;

import java.util.ArrayList;

/**
 * Created by Viachaslau_Kavaliou on 17/12/2017.
 */
public class Nominator {
    private String name;
    private int nominatorAwardQuantityLimit;
    private float nominatorAwardAmountLimit;
    private ArrayList<Award> array = new ArrayList<Award>();
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

    public void getNominatorParams () {
        System.out.println("Nominator is " + this.getName() + ". Max award value is " + this.nominatorAwardAmountLimit + ". Limit of awards is " + this.nominatorAwardQuantityLimit + " items");
    }

    public void nominate(Award award, Nominee nominee) {
        int restOfAwards = getRestOfNominatorsAwards();
        double nominatorBalance = this.nominatorAwardAmountLimit;
        while (restOfAwards > 0 && nominatorBalance > 0) {
            switch (restOfAwards) {
                case 1:
                    System.out.println(this.getName() + " is able to give only 1 award");
                    break;
                default:
                    System.out.println(this.getName() + " is able to give " + restOfAwards + " awards");
                    break;
            }
            array.add(award);
            nominee.receiveAward(award);
            nominatorBalance -= award.getValue();
            System.out.println(this.name + " has balance " + nominatorBalance);
            break;
        }
        if (restOfAwards <= 0) {
            System.out.println("Nominator " + this.name + " hasn't been able to give any awards yet.");
        } else if (nominatorBalance <= 0) {
            System.out.println("Nominator has reached limit of awards amount");
        }
//            nominee.receiveAward(award);
//            nominatorAwardsAmount = nominatorAwardsAmount + award.getValue();
//        }
//        if (this.getNominatorAwardAmountLimit() < award.getValue()) {
//            System.out.println("Nominator isn't able to give an award = " + award.getValue());
//            System.out.println(this.getNominatorAwardAmountLimit());
//        } else if (this.get)
//
//        else {

//        }
    }

    public int getRestOfNominatorsAwards() {
        int restOfNominatorAwards = this.nominatorAwardQuantityLimit;

        for (Award award : array) {
            restOfNominatorAwards--;

        }
        return restOfNominatorAwards;
    }


    public void nominate1(Award award, Nominee nominee) {
        nominee.receiveAward1(award);
    }
}

