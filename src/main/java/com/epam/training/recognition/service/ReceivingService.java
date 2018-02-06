package com.epam.training.recognition.service;

import com.epam.training.recognition.entity.Award;
import com.epam.training.recognition.entity.Nominator;
import com.epam.training.recognition.entity.Nominee;
import com.epam.training.recognition.entity.Person;
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
        showSoli(nominee, award);
        nominee.getAllAwards().add(award);
        if (award.getSoli() <= 0) {
            nominee.getAwardsWitoutSoli().add(award);
        }
        nominee.setAwardAmountLimit(nominee.getAwardAmountLimit() - award.getValue());
        nominee.setAwardQuantityLimit(nominee.getAwardQuantityLimit() - 1);
        NominationService.printBalance(false, nominee.getAwardQuantityLimit(), nominee.getAwardAmountLimit(), nominee.getName());
    }

    public void showSoli(Nominee nominee, Award award) {
        if (award.getSoli() > 0) {
            System.out.println("Due to SOLI index, the actual amount of the award is " + award.getSoli() + " USD. It is " + award.getSoli() / award.getValue() * 100 + "% of the award amount.");
        } else {
            System.out.println("SOLI index isn't applied for this award. The actual amount of the award is " + award.getValue() + " USD.");
            System.out.println("Quantity = " + NominationHelper.getQuantity(nominee.getAwardsWitoutSoli(), award.getValue(), nominee.getZ(), nominee.getC()));
        }
    }

}

