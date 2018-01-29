package com.epam.training.recognition.service;

import com.epam.training.recognition.entity.Award;
import com.epam.training.recognition.entity.Nominee;
import com.epam.training.recognition.view.Runner;

/**
 * Created by Viachaslau_Kavaliou on 23/01/2018.
 */
public class ReceivingService {

    /**
     * Method 'recieveAward' defines whether nominee is able to receive an award or not according to his own award quantity (nomineeAwardQuantityLimit) and award amount limit (nomineeAwardAmountLimit).
     * Every successfully received award reduces this limit.
     * If award doesn't have soli, appropriate message displays
     * If award has soli, quantity indicator is calculated by formula in NominationHelper utility class
     *
     * @param award   - award that nominator is intending to give to nominee
     * @param nominee - eligible nominee who will receive a recognition
     */
    public void receiveAward(Award award, Nominee nominee) {
        Runner runner = new Runner();
        runner.showSoli(award.getSoli(), nominee, award);
        nominee.getAllAwards().add(award);
        if (award.getSoli() <= 0) {
            nominee.getAwardsWitoutSoli().add(award);
        }
        nominee.setAwardAmountLimit(nominee.getAwardAmountLimit() - award.getValue());
        nominee.setAwardQuantityLimit(nominee.getAwardQuantityLimit() - 1);
        runner.printBalance(false, nominee.getAwardQuantityLimit(), nominee.getAwardAmountLimit(), nominee.getName());
    }
}
