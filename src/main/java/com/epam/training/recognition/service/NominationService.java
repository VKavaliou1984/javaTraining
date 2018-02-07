package com.epam.training.recognition.service;
import com.epam.training.recognition.entity.*;

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
     *  @param award     - award that nominator is going to give to nominee
     * @param nominee   - nominee whom nominator wants to recognize
     * @param nominator - nominator, the person who wants to recongize another person
     */
    public Nomination nominate(Award award, Nominee nominee, Nominator nominator) {
        Nomination nomination = new Nomination (nominee,nominator,award);
        if ((nominator.isEligible(award.getValue()) && (nominee.isEligible(award.getValue())))) {
            nomination.setStatus(0);
            nominator.setAwardQuantityLimit(nominator.getAwardQuantityLimit() - 1);
            nominator.setAwardAmountLimit(nominator.getAwardAmountLimit() - award.getValue());
            printBalance(true, nominator.getAwardQuantityLimit(), nominator.getAwardAmountLimit(), nominator.getName());
            ReceivingService receivingService = new ReceivingService();
            receivingService.receiveAward(award, nominee);
        } else if (!nominator.isEligible(award.getValue()) && (nominee.isEligible(award.getValue()))) {
            nomination.setStatus(1);
        } else {
            nomination.setStatus(2);
        }
        return nomination;
    }

    public static void printBalance(boolean isNominator, int getAwardQuantityLimit, float getAwardAmountLimit, String name) {
        if (isNominator) {
            System.out.println(name + " (nominator) has balance " + getAwardAmountLimit + " USD");
            System.out.println("Nominator is able to give " + getAwardQuantityLimit + " awards");
        } else {
            System.out.println(name + " (nominee) has balance " + getAwardAmountLimit + " USD");
            System.out.println("Nominee is able to receive " + getAwardQuantityLimit + " awards");
            System.out.println("================================================");
        }
    }
}
