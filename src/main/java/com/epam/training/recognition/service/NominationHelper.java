package com.epam.training.recognition.service;

import com.epam.training.recognition.entity.Award;

import java.util.ArrayList;

/**
 * @author Viachaslau_Kavaliou
 * @version 1.0, 17-DEC-2017
 */
public class NominationHelper {

    private NominationHelper() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Method getQuantity counts quantity of nominee's awards without soli
     *
     * @param value award value
     * @param z     andom whole number
     * @param c     random decimal
     * @param array array of employee's awards without soli
     * @return quantity
     */
    public static double getQuantity(ArrayList<Award> array, int value, int z, double c) {
        double x = ((z * z * value) * (1 - value)) / (c * c);
        return (x / ((1 + ((x - 1) / getPopulation(array)))));
    }

    /**
     * Method "getPopulation" calculates amount of nominee's awards without soli after each successfully placing nomination cycle
     *
     * @param array array of employee's awards without soli
     * @return amount of awards without soli
     */

    public static int getPopulation(ArrayList<Award> array) {
        int population = 1;
        for (Award award : array) {
            population++;
        }
        return population;
    }
}
