package com.epam.javaTraining;

/**
 * Created by Viachaslau_Kavaliou on 17/12/2017.
 */
public class Nominator {
    private String name;

    public Nominator(String name) {
        this.name = name;
    }


    public void nominate(Award award, Nominee nominee) {
        System.out.println(this.name + " " + award.getValue() + " " + nominee.getName());
        nominee.receiveAward(award);
    }

}

