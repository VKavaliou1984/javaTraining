package com.epam.javaTraining.lecture2;

/**
 * Created by Viachaslau_Kavaliou on 18/12/2017.
 */
public class Runner {

    static {
        System.out.println("Hello from Runner class");
    }

    public static void main(String[] args) {
        Nominee nominee1 = new Nominee("Jack", 500.0f, 10);
        Nominee nominee2 = new Nominee("Siarhei", 10000.0f, 3);
        Nominee nominee3 = new Nominee("Stephen", 2000.0f, 5);
        Award award1 = new Award(2000, 1700f);
        Award award2 = new Award(50, 0f);
        Award award3 = new Award(100);
        Nominator nominator1 = new Nominator("John", 3000.0f, 5);
        Nominator nominator2 = new Nominator("Aleh", 1000.0f, 1);
        nominator1.nominate(award1, nominee1);
        nominator2.nominate(award1, nominee1);
        nominator1.nominate(award3, nominee2);
        nominator2.nominate(award1, nominee3);
        nominator2.nominate(award2, nominee3);
        nominator1.nominate(award2, nominee2);
        System.out.println("nominator limit is " + nominator1.getNominatorAwardQuantityLimit());

        for (int i=0; i<nominator1.getNominatorAwardQuantityLimit();i++){
            nominator1.nominate1(award1, nominee1);
            System.out.println(i + "test" + award1.getValue());
        }
        System.out.println("The limit of awards has been reached for the nominator");
    }

}




