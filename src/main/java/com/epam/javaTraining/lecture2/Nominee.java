package com.epam.javaTraining.lecture2;

/**
 * Created by Viachaslau_Kavaliou on 17/12/2017.
 */
public class Nominee {
    private String name;
    private final double c = 0.05;
    private int p;
    private int final z = 3;
    private float quantity;


    public Nominee(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public void receiveAward(Award award) {
        if (award.getSoli() >0) {
            System.out.println("Nominee is " + name + ". Due to SOLI index, the actual amount of the award is " + award.getSoli() + " USD. It is " + award.getSoli()/award.getValue()*100 + "% of the award amount.");
        }
        else {
            System.out.println("Nominee is " + name + ". SOLI index isn't applied for this award. The actual amount of the award is " + award.getValue() + " USD.");
            quantity = (getZ()*getZ()*getP()*(1-getP()))/(getC()*getC()) / (1 + ((((getZ()*getZ()*getP()*(1-getP() ))/(getC()*getC())-1)/getP())));
        }
            }

    }

    }
