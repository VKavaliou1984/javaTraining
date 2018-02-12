package com.epam.training.recognition.service;

import com.epam.training.recognition.exception.AwardConfigurationException;
import com.epam.training.recognition.view.Type;

/**
 * Created by Viachaslau_Kavaliou on 12/02/2018.
 */
public class AwardHelper {

    /**
     * This method checks whether Soli is less or equal award value
     *
     * @param awardValue award value
     * @param soli       soli for the award
     */
    public void checkSoli(int awardValue, double soli) {
        System.out.println("AwardHelper checkSoli (int awardValue, double soli) is working");
        try {
            System.out.println("try");
            if (soli >= awardValue) {
                throw new AwardConfigurationException("Soli can't be more than award value");
            }
        } catch (Exception e) {
            System.out.println("catch");
            System.out.println("Catch block in AwardHelper.checkSoli() " + e);
        } finally {
            System.out.println("finally");
            System.out.println("Finally block in AwardHelper.checkSoli(). Always executable");
        }
    }

    /**
     * This method checks whether Soli is less or equal award value
     * @param awardValue
     * @param type
     * @throws AwardConfigurationException
     */
    public void checkAwardType(int awardValue, Type type) throws AwardConfigurationException {
        System.out.println("AwardHelper checkAwardType (int awardValue, Type type) is working");
        if (awardValue != 0 && type == Type.ZERO_VALUE) {
            System.out.println("Award value for zero-value is not 0");
            System.out.println("throw new MissedValueException");
            throw new AwardConfigurationException("Award value for zero-value should be 0");
        } else if (awardValue == 0 && type != Type.ZERO_VALUE) {
            System.out.println("Award value for cash or non-cash award is 0");
            System.out.println("throw new MissedValueException");
            throw new AwardConfigurationException("Award value for cash or non-cash should be > 0");
        }
    }
}
