package model;

import java.math.*;
import java.text.*;

public class Monomial implements Comparable<Monomial>{
    private double coefficient;
    private int power;

    public Monomial(double coefficient, int power) {
        this.coefficient = coefficient;
        this.power = power;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public int compareTo(Monomial mon) {
        if(this.power > mon.getPower()){
            return -1;
        }
        else if (this.power < mon.getPower()){
            return 1;
        }
        else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object monomial){
        double epsilon = 0.000001;
        if ((Math.abs(this.getCoefficient() - ((Monomial)monomial).getCoefficient()) <= epsilon) && this.getPower() == ((Monomial)monomial).getPower()){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(this.coefficient) + "X^" + this.power;
    }
}
