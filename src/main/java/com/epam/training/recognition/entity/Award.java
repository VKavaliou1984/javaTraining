package com.epam.training.recognition.entity;

import com.epam.training.recognition.service.NominationHelper;

import java.util.ArrayList;

/**
 * @author Viachaslau_Kavaliou
 * @version 1.0, 17-DEC-2017
 */
public class Award {
    private final int value;
    private float soli;
    private String type;
    private int id;

    /**
     * creating award without SOLI
     *
     * @param value base value of the award that will be visible either for nominee or nominator
     */
    public Award( Integer value, String type) {
        this.value = value;
        this.type = type;
    }

    /**
     * creating award with SOLI
     *
     * @param value base value of the award
     * @param soli  actual value of the awards that will be visible for nominee
     */
    public Award(Integer value, Float soli, String type) {
        this(value, type);
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Award award = (Award) o;

        if (value != award.value) return false;
        if (Float.compare(award.soli, soli) != 0) return false;
        if (id != award.id) return false;
        return type.equals(award.type);
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + (soli != +0.0f ? Float.floatToIntBits(soli) : 0);
        result = 31 * result + type.hashCode();
        result = 31 * result + id;
        return result;
    }
}



