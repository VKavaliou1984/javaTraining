package com.epam.javaTraining.lecture2;

/**
 * Created by Viachaslau_Kavaliou on 17/12/2017.
 */
public class Nominee {
    private String name;
    public Nominee(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void receiveAward(Award award) {
        System.out.println(award.getValue());
    }

    }
