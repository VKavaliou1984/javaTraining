package com.epam.javaTraining.globoforceTestProject;

import java.util.ArrayList;

/**
 * @author Viachaslau_Kavaliou
 * @version 1.0, 17-DEC-2017
 */
public final class NominationHelper {

    /**
     * Method getQuantity counts quantity of nominee's awards without soli
     *
     * @param value      award value
     * @param z          andom whole number
     * @param c          random decimal
     * @param population amount of employee's awards without soli
     * @return quantity
     */
    public static double getQuantity(int value, int z, double c, int population) {
        double x = ((z * z * value) * (1 - value)) / (c * c);
        double quantity = x / ((1 + ((x - 1) / population)));
        return quantity;
    }

    /**
     * Method "getPopulation" calculates amount of nominee's awards without soli after each successfully placing nomination cycle
     *
     * @return amount of awards without soli
     */
    public static int getPopulation(ArrayList<Award> array) {
        int population = 0;
        for (Award award : array) {
            if (award.getSoli() <= 0) {
                population++;
            }
        }
        return population;
    }

}
