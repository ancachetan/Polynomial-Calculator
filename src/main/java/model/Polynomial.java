package model;

import java.util.*;
import java.lang.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private ArrayList<Monomial> monomials;

    public Polynomial(ArrayList<Monomial> monomials) {
        this.monomials = monomials;
    }

    public ArrayList<Monomial> getMonomials() {
        return monomials;
    }

    public void setMonomials(ArrayList<Monomial> monomials) {
        this.monomials = monomials;
    }

    @Override
    public String toString() {
        String result = "";

        for (int i = 0; i < monomials.size(); i++){
            if (monomials.get(i).getCoefficient() != 0) {
                if (i <= monomials.size() - 2) {
                    if (monomials.get(i + 1).getCoefficient() > 0) {
                        result = result + monomials.get(i).toString() + " +";
                    } else {
                        result = result + monomials.get(i).toString() + " ";
                    }
                }
                else{
                    result = result + monomials.get(i).toString() + " +";
                }
            }
        }

        if (result.length() > 2) {
            if ((result.charAt(result.length() - 1)) == '+') {
                result = result.substring(0, result.length() - 2);
            }
        }

        return result;
    }

    public static Polynomial getPolynomial(String textPolynomial){
        String textPolynomialAux;

        if (String.valueOf(0).equals('-'))
            textPolynomialAux = textPolynomial;
        else
            textPolynomialAux = '+' + textPolynomial;

        String polynomialPattern = "[+-]?(?:(?:([+-]\\d+)x)\\^(\\d+))|(?:([+-]\\d+))";
        String polynomialText = textPolynomialAux;
        Polynomial polynomial = new Polynomial(new ArrayList<Monomial>());

        Pattern pattern = Pattern.compile(polynomialPattern);
        Matcher matcher = pattern.matcher(polynomialText);

        while (matcher.find()){
            double coeff = Double.parseDouble(matcher.group(1));
            int pow = Integer.parseInt(matcher.group(2));
            Monomial mon = new Monomial(coeff, pow);
            polynomial.getMonomials().add(mon);
        }

        return polynomial;
    }

    @Override
    public boolean equals(Object polynomial){

        if (((Polynomial)polynomial).getMonomials().size() != this.getMonomials().size())
            return false;

        Collections.sort(this.getMonomials());
        Collections.sort(((Polynomial) polynomial).getMonomials());

        for (int i = 0; i < this.getMonomials().size(); i++){
            if (!(((Polynomial)polynomial).getMonomials().get(i).equals(this.getMonomials().get(i)))){
                return false;
            }
        }

        return true;
    }
}
