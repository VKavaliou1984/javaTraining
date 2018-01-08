package com.epam.javaTraining.globoforceTestProject;

/**
 * @author Viachaslau_Kavaliou
 * @version 1.0, 17-DEC-2017
 */
public class Runner {

    static {
        System.out.println("Hello from Runner class");
    }

    /**
     * Method "main" is used for nominees, nominators and awards objects creation
     * @param args array of String objects
     */
    public static void main(String[] args) {
        Nominee nominee1 = new Nominee("Jack", 500.0f, 2);
        Nominee nominee2 = new Nominee("Siarhei", 10000.0f, 3);
        Nominee nominee3 = new Nominee("Stephen", 2000.0f, 5);

        Award award1 = new Award(2000, 1700f);
        Award award2 = new Award(50, 0f);
        Award award3 = new Award(100);
        Nominator nominator1 = new Nominator("John", 3000.0f, 6);
        Nominator nominator2 = new Nominator("Aleh", 100.0f, 2);
        Nominator nominator3 = new Nominator("Jack");
        nominator3.toString();nominator3.nominate(award1, nominee3);
        nominator2.nominate(award2, nominee1);
        nominator2.nominate(award3, nominee2);
        nominator2.nominate(award1, nominee2);
        nominator1.nominate(award2, nominee3);
        nominator1.nominate(award2, nominee3);
        nominator1.nominate(award3, nominee3);
        nominator1.nominate(award2, nominee3);

//        for (int i =1; i< nominator1.getNominatorAwardQuantityLimit(); i++) {
//            nominator1.nominate1(award1, nominee1);
//            System.out.println(i + "test" + award1.getValue());
//        }
//        System.out.println("The limit of awards has been reached for the nominator");
//
//        int j = 0;
//        do {
//            nominator1.nominate1(award1, nominee1);
//            j++;
//            System.out.println(j+"test2"+award1.getValue());
//        }
//        while (nominee1.getNomineeAwardQuantityLimit() > j);

    }
}




