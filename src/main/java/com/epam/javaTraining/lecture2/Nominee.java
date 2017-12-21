package com.epam.javaTraining.lecture2;

/**
 * Created by Viachaslau_Kavaliou on 17/12/2017.
 */
public class Nominee {
    private String name;
    private final double c = 0.05;
    private double x;
    private final int z = 3;
    private double quantity;
    public static int counter = 0;

    public Nominee(String name) {
        this.name = name;
        counter++;
    }

    public String getName() {
        return name;
    }

    public void receiveAward(Award award) {
        if (award.getSoli() > 0) {
            System.out.println("Nominee is " + name + ". Due to SOLI index, the actual amount of the award is " + award.getSoli() + " USD. It is " + award.getSoli() / award.getValue() * 100 + "% of the award amount.");
        } else {
            System.out.println("Nominee is " + name + ". SOLI index isn't applied for this award. The actual amount of the award is " + award.getValue() + " USD.");
            x = (z * z * award.getValue()) * (1 - award.getValue()) / (c * c);
            quantity = x / ((1 + (x - 1) / counter));
            System.out.println("Quantity = " + quantity);
            System.out.println("FYI: x=" + x);
        }
    }

}

