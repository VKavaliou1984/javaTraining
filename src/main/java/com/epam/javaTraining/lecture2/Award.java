package com.epam.javaTraining.lecture2;

/**
 * Created by Viachaslau_Kavaliou on 17/12/2017.
 */
public class Award {
    private final int value;
    private float soli;
    public int counter;

    static {
        System.out.println("Hello from Award class");
    }

    /**
     * creating award without SOLI
     * @param value base value of the award that will be visible either for nominee or nominator
     */
    public Award(Integer value) {
        this.value = value;
        counter++;
    }

    /**
     * creating award with SOLI
     * @param value base value of the award
     * @param soli actual value of the awards that will be visible for nominee
     */
    public Award(Integer value, Float soli) {
        this.value = value;
        this.soli = soli;
    }

    public int getValue() {
        return value;
    }

    public void setSoli(float soli) {
        this.soli = soli;
    }

    public float getSoli() {
        return soli;
    }

//    public int count () {
//        int i; int count = 0;
//        for (i = 0; i < counter; i++)
//        if (getSoli()<=0) {
//            count++;
//        }
//        return count;
//    }
}



