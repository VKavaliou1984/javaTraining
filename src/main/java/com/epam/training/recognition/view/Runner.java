package com.epam.training.recognition.view;

import com.epam.training.recognition.entity.*;
import com.epam.training.recognition.service.NominationHelper;
import com.epam.training.recognition.service.NominationService;
import java.util.Scanner;

/**
 * @author Viachaslau_Kavaliou
 * @version 1.0, 17-DEC-2017
 */
public class Runner {

    /**
     * Method "main" is used for nominees, nominators and awards objects creation
     *
     * @param args array of String objects
     */
    public static void main(String[] args) {
//        Runner runner = new Runner();
//        Scanner nominator = new Scanner(System.in);
//        System.out.println("Please enter amount of nominators");
//        int num = nominator.nextInt();
//        String[] name = new String[num];
////        int[] awardQuanityLimit = new int[num];
////        float[] awardAmountLimit = new float[num];
//        for (int i = 0; i < name.length; i++) {
//            System.out.println("Enter nominator " + i + ":");
//            name[i] = nominator.next();
//        }


        NominationService nominationService = new NominationService();
//        Nominee nominee1 = new Nominee(sc.next(), 1, 50000f);
        Person nominee1 = new Nominee("Siarhei");
        Person nominee2 = new Nominee("Greg", 10, 500000);
        Person nominee3 = new Nominee("Stephen", 5, 20000);
        Person nominee4 = new Nominee("Yuliya");
        Award award1 = new Award(500,495.0f, "cash");
        Award award2 = new Award(50, "non-cash");
        Award award3 = new Award(100, "cash");
        Award award4 = new Award (10000000, "cash");
        Person nominator1 = new Nominator("John", 10, 10000);
        Person nominator2 = new Nominator("Aleh");
        Person nominator3 = new Nominator("Jack", 10, 50000);
        Person nominator4 = new Nominator("Elena");

        nominationService.nominate(award1, (Nominee) nominee1, (Nominator) nominator2);
        nominationService.nominate(award2, (Nominee)nominee1, (Nominator) nominator2);
        nominationService.nominate(award3, (Nominee)nominee3, (Nominator) nominator1);
        nominationService.nominate(award2, (Nominee)nominee4, (Nominator) nominator1);
        nominationService.nominate(award2, (Nominee)nominee3, (Nominator) nominator2);
        nominationService.nominate(award2, (Nominee) nominee1, (Nominator) nominator1);

        Nomination nomination1 = nominationService.nominate(award1, (Nominee) nominee1, (Nominator) nominator2);
        NominationHelper.printStatus(nomination1.getStatus());


        Nomination nomination3 = nominationService.nominate(award3, (Nominee) nominee2, (Nominator) nominator3);
        NominationHelper.printStatus(nomination3.getStatus());

        Nomination nomination4 = nominationService.nominate(award4, (Nominee) nominee2, (Nominator) nominator3);
        NominationHelper.printStatus(nomination4.getStatus());


//      Examples how works method toString for Nominator class (where it is overriden) and fpr Nominee class (be default)
        System.out.println(nominator1.toString());
        System.out.println(nominee1.toString());
    }
    }




