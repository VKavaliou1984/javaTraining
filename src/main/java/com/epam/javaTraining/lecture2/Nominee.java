package com.epam.javaTraining.lecture2;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Viachaslau_Kavaliou on 17/12/2017.
 */
public class Nominee {
    private String name;
    private double x;
    private double quantity;
    public int population;
    private int nomineeAwardQuantityLimit;
    private float nomineeAwardAmountLimit;

    static {
        System.out.println("Hello from Nominee class");
    }


    public Nominee(String name, float nomineeAwardAmountLimit, int nomineeAwardQuantityLimit) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNomineeAwardQuantityLimit() {
        return nomineeAwardQuantityLimit;
    }


    public void setNomineeAwardQuantityLimit(int nomineeAwardQuantityLimit) {
        this.nomineeAwardQuantityLimit = nomineeAwardQuantityLimit;
    }

    public float getNomineeAwardAmountLimit() {
        return nomineeAwardAmountLimit;
    }

    public void setNomineeAwardAmountLimit(float nomineeAwardAmountLimit) {
        this.nomineeAwardAmountLimit = nomineeAwardAmountLimit;
    }

//    public int getPopulation () {
//        int[] arr;
//        arr = new int[];
//        for (int i = 0; i < arr.length; i++) {
//            if (award.getSoli() <= 0) {
//                population++;
//            }
//        }
//    return population;
 //   }

//    public int getCounter(Award award) {
//        int i; population = 0;
//        for (i = 0; i < award.counter; i++)
//           // if (award.getSoli()<=0) {
//                population++;
//           // }
//        return population;
//}
//    public void getPopulation () {
//        System.out.println("Quantity = " + population);
//    }

    public void receiveAward(Award award) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Random rand = new Random();
        double c = rand.nextInt(5) + rand.nextDouble();
        Random rand1 = new Random();
        int z = rand.nextInt(10);
        arrayList.add(award.getValue());
        population = 4;
        System.out.println(arrayList);
        if (award.getSoli() > 0) {
            System.out.println("Nominee is " + name + ". Due to SOLI index, the actual amount of the award is " + award.getSoli() + " USD. It is " + award.getSoli() / award.getValue() * 100 + "% of the award amount.");
        } else {
            System.out.println("Nominee is " + name + ". SOLI index isn't applied for this award. The actual amount of the award is " + award.getValue() + " USD.");
            x = ((z * z * award.getValue()) * (1 - award.getValue())) / (population);
            quantity = x / ((1 + ((x - 1) / population)));
            System.out.println("Quantity = " + population);
            System.out.println("FYI: x=" + x + ", c=" + c + ", z=" + z);
        }
    }
}

