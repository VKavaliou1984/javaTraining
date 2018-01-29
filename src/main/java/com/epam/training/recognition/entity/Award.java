package com.epam.training.recognition.entity;

import java.util.ArrayList;

/**
 * @author Viachaslau_Kavaliou
 * @version 1.0, 17-DEC-2017
 */
public class Award {
    private final int value;
    private float soli;
    private ArrayList<Award> array = new ArrayList<Award>();

    /**
     * creating award without SOLI
     *
     * @param value base value of the award that will be visible either for nominee or nominator
     */
    public Award(Integer value) {
        this.value = value;
    }

    /**
     * creating award with SOLI
     *
     * @param value base value of the award
     * @param soli  actual value of the awards that will be visible for nominee
     */
    public Award(Integer value, Float soli) {
        this.value = value;
        this.soli = soli;
    }

    public ArrayList<Award> getArray() {
        return array;
    }

    public void setArray(ArrayList<Award> array) {
        this.array = array;
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
}



