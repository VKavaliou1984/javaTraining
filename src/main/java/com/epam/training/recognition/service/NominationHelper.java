package com.epam.training.recognition.service;

import com.epam.training.recognition.entity.Award;
import com.epam.training.recognition.view.Type;

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

    public static int getPopulation(ArrayList<Award> array)  {
        int population = 1;
//        population += array.size();
        System.out.println(array.size());
        for (Award award : array) {
            if (award.getSoli() <= 0) {
                population++;
            }
        }
        return population++;
    }

    public static void printStatus(int status) {
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

//    @Override
//    public String toString() {
//        return award;
//    }


    public static void printAwards(ArrayList<Award> array, Type type){
        System.out.println(type + " awards of the array:");
        for (Award award : array) {
            if (award.getType() == type) {
                switch (award.getType()) {
                    case CASH:
                    case NON_CASH:
                    case ZERO_VALUE:
                        System.out.println(
                                award.getValue() + " USD. ID: " + array.indexOf(award));
                        break;
                }
            }
        }
    }


//        System.out.println("Cash awards:");
//        for (Award award : array) {
//            if (award.getType().contains("Cash")) {
//                System.out.println(
//                        award.getValue() + " USD. ID: " + array.indexOf(award));
//            }
//        }
//        System.out.println("Non-cash awards:");
//        for (Award award : array) {
//            if (award.getType().contains("Non-cash")) {
//                System.out.println(
//                        award.getValue()+ " USD. ID: " + array.indexOf(award));
//            }
//        }
//        System.out.println("Zero-value awards:");
//        for (Award award : array) {
//            if (award.getType().contains("Zero-value")) {
//                System.out.println("ID: " + array.indexOf(award));
//            }
//


    public static void printAwards2(Award... array) {
        System.out.println("3 dots:");
        for (Award award : array) {
                System.out.println(
                        award.getValue());
            }
        }
    }


