package com.epam.training.recognition.entity;

/**
 * Created by Viachaslau_Kavaliou on 02/02/2018.
 */
public class Nomination {
    private Nominee nominee;
    private Nominator nominator;
    private Award award;
    private int status;


    public Nominee getNominee() {
        return nominee;
    }

    public void setNominee(Nominee nominee) {
        this.nominee = nominee;
    }

    public Nominator getNominator() {
        return nominator;
    }

    public void setNominator(Nominator nominator) {
        this.nominator = nominator;
    }

    public Award getAward() {
        return award;
    }

    public void setAward(Award award) {
        this.award = award;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Nomination(Nominee nominee, Nominator nominator, Award award) {
        this.nominee = nominee;
        this.nominator = nominator;
        this.award = award;
    }

}