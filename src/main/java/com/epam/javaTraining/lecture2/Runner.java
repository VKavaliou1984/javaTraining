package com.epam.javaTraining;

/**
 * Created by Viachaslau_Kavaliou on 18/12/2017.
 */
public class Runner {

    public static void main(String[] args) {
        Nominee nominee = new Nominee("Jack");
        Nominee nominee2 = new Nominee("Siarhei");
        Award award = new Award(2000);
        Award award2 = new Award (0);
        Award award3 = new Award (100);
        nominee.receiveAward(award);
        Nominator nominator = new Nominator("John");
        nominator.nominate(award,nominee);
        nominator.nominate(award2,nominee);
        nominator.nominate(award3,nominee2);
    }
}
