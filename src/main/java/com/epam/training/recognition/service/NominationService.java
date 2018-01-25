package com.epam.training.recognition.service;

import com.epam.training.recognition.entity.Award;
import com.epam.training.recognition.entity.Nominator;
import com.epam.training.recognition.entity.Nominee;
import com.epam.training.recognition.view.Runner;

/**
 * Created by Viachaslau_Kavaliou on 23/01/2018.
 */
public class NominationService {

    /**
     * * Method 'nominate' defines whether nominator is able to give an award or not according to his own award quantity (nominatorAwardQuantityLimit) and award amount limit (nominatorAwardAmountLimit).
     * Every successfully given award reduces this limit.
     * If award value is higher than nominator's balance but nominator is still able to give awards, appropriate message is displayed.
     * If award value is less than nominator's balance but nominator isn't able to give any awards, the message that nominator has already reached his own limit of awards is displayed.
     * If nominator's balance is less than award value and nominator isn't able to give any awards, the message that nominator hasn't been able to give any awards yet is displayed.
     *
     * @param award     - award that nominator is going to give to nominee
     * @param nominee   - nominee whom nominator wants to recognize
     * @param nominator - nominator, the person who wants to recongize another person
     */
    public void nominate(Award award, Nominee nominee, Nominator nominator) {
        //        System.out.println("---------------Attempt to give award # " + nominator.getCount() + " by nominator " + nominator.getName() + " ---------------");
//        System.out.println(nominator.isEligible(award.getValue(), nominator.getAwardQuantityLimit(), nominator.getAwardQuantityLimit()));
//        System.out.println(nominee.canBeNominated(award));
        //if (nominator.getAwardQuantityLimit() > 0 && nominator.getAwardAmountLimit() > award.getValue() && nominee.getAwardQuantityLimit() > 0 && nominee.getAwardAmountLimit() > award.getValue() ) {
        if (nominator.isEligible(award.getValue(), nominator.getAwardQuantityLimit(), nominator.getAwardAmountLimit()) && nominee.isEligible(award.getValue(), nominee.getAwardQuantityLimit(), nominee.getAwardAmountLimit())) {
            Runner.nominationStatus(0);
            nominator.setAwardQuantityLimit(nominator.getAwardQuantityLimit() - 1);
            nominator.setAwardAmountLimit(nominator.getAwardAmountLimit() - award.getValue());
            Runner runner = new Runner();
            runner.printBalance(true, nominator.getAwardQuantityLimit(), nominator.getAwardAmountLimit(), nominator.getName());
            ReceivingService receivingService = new ReceivingService();
            receivingService.receiveAward(award, nominee);
        } else if (nominator.getAwardAmountLimit() <0) {
            Runner.nominationStatus(1);
        }
// else if (nominator.getAwardQuantityLimit() > 0 && nominator.getAwardAmountLimit() < award.getValue()) {
//            System.out.println("It's impossible to create an award that has value " + award.getValue() + " USD (more than nominator's balance)");
//            System.out.println("================================================");
//        } else if (nominator.getAwardQuantityLimit() <= 0 && nominator.getAwardAmountLimit() >= award.getValue()) {
//            System.out.println("Regardless nominator's balance allows to give awards, he has already reached his own limit of awards.");
//        } else {
//            System.out.println(nominator.getName() + " hasn't been able to give any awards yet");
//        }
    }
}
