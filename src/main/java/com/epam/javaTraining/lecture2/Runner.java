package com.epam.javaTraining.lecture2;

/**
 * Created by Viachaslau_Kavaliou on 18/12/2017.
 */
public class Runner {

    public static void main(String[] args) {
        Nominee nominee1 = new Nominee("Jack");
        Nominee nominee2 = new Nominee("Siarhei");
        Nominee nominee3 = new Nominee("Stephen");
        Award award1 = new Award(2000);
        Award award2 = new Award (50);
        Award award3 = new Award (100);
        award1.setSoli((float) 1700);
        award2.setSoli(0);
        Nominator nominator1 = new Nominator("John");
        Nominator nominator2 = new Nominator("Aleh");
        nominator1.nominate(award1,nominee1);
        nominator2.nominate(award1,nominee1);
        nominator1.nominate(award3,nominee2);
        nominator2.nominate(award1,nominee3);
        nominator2.nominate(award2,nominee3);
        nominator1.nominate(award2,nominee2);

    }
}
