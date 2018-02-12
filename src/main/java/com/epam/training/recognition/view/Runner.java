package com.epam.training.recognition.view;
import com.epam.training.recognition.entity.*;
import com.epam.training.recognition.exception.AwardConfigurationException;
import com.epam.training.recognition.service.AwardHelper;
import com.epam.training.recognition.service.NominationHelper;
import com.epam.training.recognition.service.NominationService;

import java.util.ArrayList;

/**
 * @author Viachaslau_Kavaliou
 * @version 1.0, 17-DEC-2017
 */

public class Runner {
    private ArrayList<Award> array = new ArrayList<Award>();

    public ArrayList<Award> getArray() {
        return array;
    }
    /**
     * Method "main" is used for nominees, nominators and awards objects creation
     *
     * @param args array of String objects
     */
    public static void main(String[] args) throws AwardConfigurationException {

        NominationService nominationService = new NominationService();
//        Nominee nominee1 = new Nominee(sc.next(), 1, 50000f);
        Person nominee1 = new Nominee("Siarhei");
        Person nominee2 = new Nominee("Greg", 10, 500000);
        Person nominee3 = new Nominee("Stephen", 5, 20000);
        Person nominee4 = new Nominee("Yuliya");
        Award award1 = new Award(500,1000f,Type.CASH);
        Award award2 = new Award(50, Type.CASH);
        Award award3 = new Award(0, Type.NON_CASH);
        Award award4 = new Award (10000000, Type.CASH);
        Award award5 = new Award (0, Type.ZERO_VALUE);
        Award award6 = new Award (50, Type.NON_CASH);
        Award award7 = new Award (1050,Type.NON_CASH);
        Award award8 = new Award (100, Type.CASH);
        Award award9 = new Award (300, Type.CASH);
        Award award10 = new Award (300, Type.NON_CASH);
        Award award11 = new Award (500,Type.ZERO_VALUE);



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

        Runner runner = new Runner();
        runner.getArray().add(award1);
        runner.getArray().add(award2);
        runner.getArray().add(award3);
        runner.getArray().add(award4);
        runner.getArray().add(award5);
        runner.getArray().add(award6);
        runner.getArray().add(award7);
        runner.getArray().add(award8);

        NominationHelper.printAwards(runner.getArray(), Type.NON_CASH);

        NominationHelper.printAwards2(award1,award2,award3,award4, award5, award6,award7,award8,award9, award10);
        NominationHelper.printAwards2(award1,award3);


        System.out.println(award1.equals(award2));
        System.out.println(award3.equals(award5));
        System.out.println(award2.equals(award6));

        AwardHelper awardHelper = new AwardHelper();
        awardHelper.checkSoli(award1.getValue(), award1.getSoli());

        awardHelper.checkAwardType(award3.getValue(),award3.getType());

    }
    }




