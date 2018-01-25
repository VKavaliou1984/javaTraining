package com.epam.training.recognition.view;

import com.epam.training.recognition.entity.Award;
import com.epam.training.recognition.entity.Nominator;
import com.epam.training.recognition.entity.Nominee;
import com.epam.training.recognition.entity.Person;
import com.epam.training.recognition.service.NominationHelper;
import com.epam.training.recognition.service.NominationService;

import java.util.Scanner;

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
     *
     * @param args array of String objects
     */
    public static void main(String[] args) {
        Runner runner = new Runner();
        Scanner nominator = new Scanner(System.in);
        System.out.println("Please enter amount of nominators");
        int num = nominator.nextInt();
        String[] name = new String[num];
        int[] awardQuanityLimit = new int[num];
        float[] awardAmountLimit = new float[num];
        for (int i = 0; i < name.length; i++) {
            System.out.println("Enter nominator " + i + ":");
            name[i] = nominator.next();
        }


        NominationService nominationService = new NominationService();
        //Nominee nominee1 = new Nominee(sc.next(), 1, 50000f);
        Nominee nominee1 = new Nominee("Siarhei");
        Nominee nominee3 = new Nominee("Stephen", 5, 20000.0f);
        Award award1 = new Award(500);
        Award award2 = new Award(50, 49f);
        Award award3 = new Award(100, 80f);
        Nominator nominator1 = new Nominator("John",2,1500000f);
        Nominator nominator2 = new Nominator("Aleh", 10, 10000.0f);
        Nominator nominator3 = new Nominator("Jack", 10, 50000f);
//        nominator3.toString();nominator3.nominate(award1, nominee3);

        nominationService.nominate(award1, nominee1, nominator1);
        nominationService.nominate(award1, nominee1, nominator1);
        nominationService.nominate(award1, nominee1, nominator1);
//        nominator2.nominate(award1, nominee2);
//        nominator2.nominate(award1, nominee2);
//        nominator1.nominate(award2, nominee3);
//        nominator1.nominate(award2, nominee3);
//        nominator1.nominate(award3, nominee3);
//        nominator1.nominate(award2, nominee3);


//        nominee1.showAwardQuantityLimit();
//        double soli = nominee1.calculateSoli(award1);
//        runner.showSoli(soli, nominee1, award1);


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

    public void printBalance(boolean isNominator, int getAwardQuantityLimit, float getAwardAmountLimit, String name) {
        if (isNominator == true) {
            System.out.println(name + " (nominator) has balance " + getAwardAmountLimit + " USD");
            System.out.println("Nominator is able to give " + getAwardQuantityLimit + " awards");
        } else {
            System.out.println(name + " (nominee) has balance "  + getAwardAmountLimit + " USD");
            System.out.println("Nominee is able to receive " + getAwardQuantityLimit + " awards");
            System.out.println("================================================");
        }
    }

    public static void nominationStatus (int status) {
        switch (status) {
            case 1:
                System.out.println("Nomination can't be placed because nominator has already reached amount awards limit");
                break;
            case 2:
                System.out.println("Nomination can't be placed because award amount is larger than nominator's awards amount limit");
                break;
            case 3:
                System.out.println("Nomination can't be placed because nominee has already reached amount awards limit");
                break;
            case 4:
                System.out.println("Nomination can't be placed because award amount is larger than nominee's award amount limit");
                break;
            case 5:
                System.out.println("Nomination can't be placed because as nominee as nominator have already reached the limit of awards amount");
                break;
            case 6:
                System.out.println("Nomination can't be placed because award amount is larger than either nominee's or nominator's award amount limit");
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
            System.out.println("Quantity = " + NominationHelper.getQuantity(nominee.array,award.getValue(),nominee.getZ(),nominee.getC()));
        }
    }
}




