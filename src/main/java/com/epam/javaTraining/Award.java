package com.epam.javaTraining;

/**
 * Created by Viachaslau_Kavaliou on 17/12/2017.
 */
public class Award {
    private int value;

    public Award(final Integer value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
// Why do we need to write: "String [] args"?
        Award award = new Award(1000);
        //      System.out.println (award.value);
    }
      //  static {
  //          System.out.println(this.getValue());
    //    }

}

