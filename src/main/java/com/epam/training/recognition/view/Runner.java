package com.epam.training.recognition.view;

import com.epam.training.recognition.entity.Award;
import com.epam.training.recognition.entity.Nominator;
import com.epam.training.recognition.entity.Nominee;
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
        Nominee nominee1 = new Nominee("Siarhei", 10, 10000);
        Nominee nominee2 = new Nominee("Greg", 10, 500000);
        Nominee nominee3 = new Nominee("Stephen", 5, 20000);
        Award award1 = new Award(500);
        Award award2 = new Award(50, 500f);
        Award award3 = new Award(100);
        Nominator nominator1 = new Nominator("John", 3, 10000);
        Nominator nominator2 = new Nominator("Aleh", 10, 10000);
        Nominator nominator3 = new Nominator("Jack", 10, 50000);

        nominationService.nominate(award1, nominee1, nominator1);
        nominationService.nominate(award2, nominee1, nominator1);
        nominationService.nominate(award3, nominee1, nominator1);
        nominationService.nominate(award2, nominee1, nominator1);
        nominationService.nominate(award2, nominee1, nominator1);
        nominationService.nominate(award2, nominee1, nominator1);

    }


    public void printBalance(boolean isNominator, int getAwardQuantityLimit, float getAwardAmountLimit, String name) {
        if (isNominator) {
            System.out.println(name + " (nominator) has balance " + getAwardAmountLimit + " USD");
            System.out.println("Nominator is able to give " + getAwardQuantityLimit + " awards");
        } else {
            System.out.println(name + " (nominee) has balance " + getAwardAmountLimit + " USD");
            System.out.println("Nominee is able to receive " + getAwardQuantityLimit + " awards");
            System.out.println("================================================");
        }
    }

    public void nominationStatus(int status) {
        switch (status) {
            case 1:
                System.out.println("Nomination can't be placed due to nominator's restrictions");
                break;
            case 2:
                System.out.println("Nomination can't be placed due to nominee's restrictions");
                break;
            default:
                System.out.println("Nomination has been placed successfully");
                break;
        }
    }

    public void showSoli(double soli, Nominee nominee, Award award) {
        if (soli > 0) {
            System.out.println("Due to SOLI index, the actual amount of the award is " + soli + " USD. It is " + soli / award.getValue() * 100 + "% of the award amount.");
        } else {
            System.out.println("SOLI index isn't applied for this award. The actual amount of the award is " + award.getValue() + " USD.");
            System.out.println("Quantity = " + NominationHelper.getQuantity(nominee.getAwardsWitoutSoli(), award.getValue(), nominee.getZ(), nominee.getC()));
        }
    }
}




