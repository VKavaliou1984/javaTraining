package com.epam.javaTraining;

/**
 * Created by Viachaslau_Kavaliou on 17/12/2017.
 */
public class Nominee {
    private String name;

    public Nominee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

  //  Nominee nominee = new Nominee("John");

    public static void receiveAward(Award award) {
        System.out.println(award.getValue());


//    }
//static {
//    System.out.println(Nominee.name);
//}


    }
}
