package com.epam.javaTraining.lecture2;

/**
 * Created by Viachaslau_Kavaliou on 17/12/2017.
 */
public class Nominator {
    private String name;

    static {
        System.out.println("Hello from Nominator class");
    }

    public Nominator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void nominate(Award award, Nominee nominee) {
        System.out.println("Nominator is " + this.name);
        nominee.receiveAward(award);
        System.out.println();
    }

}

