package model;

import java.util.ArrayList;
import java.util.Collections;

public class Operations {

    public static Polynomial addOperation(Polynomial p1, Polynomial p2){
        Polynomial polSum = new Polynomial(new ArrayList<Monomial>());

        for (Monomial pol1: p1.getMonomials()) {
            boolean ok = false;

            for (Monomial pol2: p2.getMonomials()){
                if (pol1.getPower() == pol2.getPower()) {
                    Monomial mon = new Monomial((pol1.getCoefficient() + pol2.getCoefficient()), pol1.getPower());
                    polSum.getMonomials().add(mon);
                    ok = true;
                }
            }

            if (ok == false){
                polSum.getMonomials().add(pol1);
            }
        }

        for (Monomial pol2: p2.getMonomials()){
            boolean ok = false;

            for (Monomial sumPol: polSum.getMonomials()){
                if (pol2.getPower() == sumPol.getPower()){
                    ok = true;
                }
            }
            if (ok == false){
                polSum.getMonomials().add(pol2);
            }
        }

        Collections.sort(polSum.getMonomials());

        return polSum;
    }

    public static Polynomial subtractOperation(Polynomial p1, Polynomial p2) {
        Polynomial polDif = new Polynomial(new ArrayList<Monomial>());

        for (Monomial pol1: p1.getMonomials()) {
            boolean ok = false;

            for (Monomial pol2: p2.getMonomials()){
                if (pol1.getPower() == pol2.getPower()) {
                    Monomial mon = new Monomial((pol1.getCoefficient() - pol2.getCoefficient()), pol1.getPower());
                    polDif.getMonomials().add(mon);
                    ok = true;
                }
            }

            if (ok == false){
                polDif.getMonomials().add(pol1);
            }
        }

        for (Monomial pol2: p2.getMonomials()){
            boolean ok = false;

            for (Monomial sumPol: polDif.getMonomials()){
                if (pol2.getPower() == sumPol.getPower()){
                    ok = true;
                }
            }
            if (ok == false){
                Monomial mon = new Monomial(-pol2.getCoefficient(), pol2.getPower());
                polDif.getMonomials().add(mon);
            }
        }

        Collections.sort(polDif.getMonomials());

        return polDif;
    }

    public static Polynomial multiplicateOperation(Polynomial p1, Polynomial p2){
        Polynomial polAux = new Polynomial(new ArrayList<Monomial>());
        Polynomial polMul = new Polynomial(new ArrayList<Monomial>());

        for (Monomial pol1: p1.getMonomials()) {
            for (Monomial pol2: p2.getMonomials()){
                Monomial mon = new Monomial((pol1.getCoefficient() * pol2.getCoefficient()), pol1.getPower() + pol2.getPower());
                polAux.getMonomials().add(mon);
            }
        }

        Collections.sort(polAux.getMonomials());

        for (Monomial polA: polAux.getMonomials()){
                boolean ok = false;
                for (Monomial polM: polMul.getMonomials()){
                    if (polA.getPower() == polM.getPower()){
                        ok = true;
                        polM.setCoefficient(polM.getCoefficient() + polA.getCoefficient());
                    }
                }

                if (ok == false){
                    polMul.getMonomials().add(new Monomial(polA.getCoefficient(), polA.getPower()));
                }
         }

        return polMul;
    }

    public static ArrayList<Polynomial> divideOperation(Polynomial p1, Polynomial p2){
        Polynomial Q = new Polynomial(new ArrayList<>());
        Polynomial R = new Polynomial(new ArrayList<>());
        ArrayList<Polynomial> divideResult = new ArrayList<Polynomial>();

        Collections.sort(p1.getMonomials());
        Collections.sort(p2.getMonomials());


        if (p1.getMonomials().get(0).getPower() >= p2.getMonomials().get(0).getPower()){
            R = p1;

            while (R.getMonomials().size() != 0 && R.getMonomials().get(0).getPower() >= p2.getMonomials().get(0).getPower()){
                Monomial mon = new Monomial(R.getMonomials().get(0).getCoefficient() / p2.getMonomials().get(0).getCoefficient(), R.getMonomials().get(0).getPower() - p2.getMonomials().get(0).getPower());
                Q.getMonomials().add(mon);

                Polynomial Qaux = new Polynomial(new ArrayList<>());
                Qaux.getMonomials().add(mon);
                Polynomial pol = Operations.multiplicateOperation(p2, Qaux);

                for (Monomial mono: pol.getMonomials()){
                    mono.setCoefficient(-mono.getCoefficient());
                }

                R = Operations.addOperation(R, pol);

                while(R.getMonomials().size() > 0 && R.getMonomials().get(0).getCoefficient() == 0.00) {
                    R.getMonomials().remove(0);
                }
            }
        }

        divideResult.add(Q);
        divideResult.add(R);

        return divideResult;
    }

    public static Polynomial derivateOperation(Polynomial p1){
        Polynomial polDeriv = new Polynomial(new ArrayList<Monomial>());

        for (Monomial pol: p1.getMonomials()){
            polDeriv.getMonomials().add(new Monomial(pol.getCoefficient() * pol.getPower(), pol.getPower() - 1));
        }

        if (polDeriv.getMonomials().get(polDeriv.getMonomials().size() - 1).getCoefficient() == 0)
            polDeriv.getMonomials().remove(polDeriv.getMonomials().size() - 1);

        return polDeriv;
    }

    public static Polynomial integrateOperation(Polynomial p1){
        Polynomial polInteg = new Polynomial(new ArrayList<Monomial>());

        for (Monomial pol: p1.getMonomials()){
            if (pol.getPower() != 0) {
                polInteg.getMonomials().add(new Monomial(pol.getCoefficient() / (pol.getPower() + 1), pol.getPower() + 1));
            }
            else{
                polInteg.getMonomials().add(new Monomial(pol.getCoefficient(), pol.getPower() + 1));
            }
        }

        return polInteg;
    }
}
