package com.epam.javaTraining;

/**
 * Created by Viachaslau_Kavaliou on 13/12/2017.
 */
public class Task3Array {
    public static void main(String args[]) {
        char[] globoforce = {'G', 'l', 'o', 'b', 'o', 'f', 'o', 'r', 'c', 'e'};
        String globoforceString = new String(globoforce);
        System.out.println("Task 3a: " + globoforceString);
        char[] charArray = globoforceString.toCharArray();
        System.out.println("Task 3b: Array length is " + charArray.length + " characters");
        char[] str = globoforceString.toCharArray();
        replaceString(str);
    }

    public static void replaceString(char[] str) {
        int length = str.length;
        for (int i = 0; i < length; i++) {
            if (str[i] == 'b') {
                str[i] = '$';
            }
        }
        System.out.println("Task 3c: " + String.valueOf(str));
    }

}

