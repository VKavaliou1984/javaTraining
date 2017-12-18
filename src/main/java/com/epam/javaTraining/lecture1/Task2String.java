package com.epam.javaTraining;

/**
 * Created by Viachaslau_Kavaliou on 13/12/2017.
 */
public class Task2String {
    public static void main(String args[]) {
        String string1 = "We make work HUMAN.";
        String string2 = "Unlock full potential. Celebrate positive moments.";
        String string3 = "Every day.";
        int leng = string2.length();
        System.out.println("Task 2a: " + "\n" + "\t" + string1 + " \n" + "\t" + string2 + "\n" + "\t" + string3);
        System.out.println("Task 2b: " + "String 2 has " + leng + " characters");
        String result = null;
        result = string1.toLowerCase() + string2.toLowerCase() + string3.toLowerCase();
        System.out.println("Task 2c: " + result);
        String result1 = result.replaceAll("e", "E");
        System.out.println("Task 2d: " + result1);
    }
}
