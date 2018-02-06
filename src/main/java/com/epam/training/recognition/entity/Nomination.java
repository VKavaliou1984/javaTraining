package com.epam.training.recognition.entity;

/**
 * Created by Viachaslau_Kavaliou on 02/02/2018.
 */
public class Nomination {
    private String nominee;
    private String nominator;
    private int award;
    private int status;


    public String getNominee() {
        return nominee;
    }

    public void setNominee(String nominee) {
        this.nominee = nominee;
    }

    public String getNominator() {
        return nominator;
    }

    public void setNominator(String nominator) {
        this.nominator = nominator;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Nomination(String nominee, String nominator, int award) {
        this.nominee = nominee;
        this.nominator = nominator;
        this.award = award;
    }

    public void printStatus() {
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

}