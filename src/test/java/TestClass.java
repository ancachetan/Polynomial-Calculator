import model.Monomial;
import model.Operations;
import model.Polynomial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;


public class TestClass {
    private Polynomial polynomial1;
    private Polynomial polynomial2;

    @BeforeEach
    public void initialize(){
        ArrayList<Monomial> monomials5 = new ArrayList<Monomial>();
        monomials5.add(new Monomial(1, 3));
        monomials5.add(new Monomial(-2, 2));
        monomials5.add(new Monomial(6, 1));
        monomials5.add(new Monomial(-5, 0));

        ArrayList<Monomial> monomials6 = new ArrayList<Monomial>();
        monomials6.add(new Monomial(1, 2));
        monomials6.add(new Monomial(-1, 0));

        polynomial1 = new Polynomial(monomials5);
        polynomial2 = new Polynomial(monomials6);
    }

    @Test
    public void addTest(){
        Polynomial result = Operations.addOperation(polynomial1, polynomial2);

        ArrayList<Monomial> monomials = new ArrayList<Monomial>();
        monomials.add(new Monomial(1, 3));
        monomials.add(new Monomial(-1, 2));
        monomials.add(new Monomial(6, 1));
        monomials.add(new Monomial(-6, 0));

        Polynomial polynomial = new Polynomial(monomials);

        assertTrue (result.equals(polynomial));
    }

    @Test
    public void subtractTest(){
        Polynomial result = Operations.subtractOperation(polynomial1, polynomial2);

        ArrayList<Monomial> monomials = new ArrayList<Monomial>();
        monomials.add(new Monomial(1, 3));
        monomials.add(new Monomial(-3, 2));
        monomials.add(new Monomial(6, 1));
        monomials.add(new Monomial(-4, 0));

        Polynomial polynomial = new Polynomial(monomials);

        assertTrue (result.equals(polynomial));
    }

    @Test
    public void multiplicateTest(){
        Polynomial result = Operations.multiplicateOperation(polynomial1, polynomial2);
        ArrayList<Monomial> monomials = new ArrayList<Monomial>();
        monomials.add(new Monomial(1, 5));
        monomials.add(new Monomial(-2, 4));
        monomials.add(new Monomial(5, 3));
        monomials.add(new Monomial(-3, 2));
        monomials.add(new Monomial(-6, 1));
        monomials.add(new Monomial(5, 0));

        Polynomial polynomial = new Polynomial(monomials);

        assertTrue (result.equals(polynomial));
    }

    @Test
    public void divideTest(){
        Polynomial result1 = Operations.divideOperation(polynomial1, polynomial2).get(0);
        Polynomial result2 = Operations.divideOperation(polynomial1, polynomial2).get(1);

        ArrayList<Monomial> monomials1 = new ArrayList<Monomial>();
        ArrayList<Monomial> monomials2 = new ArrayList<Monomial>();

        monomials1.add(new Monomial(1, 1));
        monomials1.add(new Monomial(-2, 0));
        monomials2.add(new Monomial(7, 1));
        monomials2.add(new Monomial(-7, 0));


        Polynomial pol1 = new Polynomial(monomials1);
        Polynomial pol2 = new Polynomial(monomials2);

        assertTrue (result1.equals(pol1));
        assertTrue (result2.equals(pol2));
    }

    @Test
    public void derivateTest(){
        Polynomial result = Operations.derivateOperation(polynomial1);

        ArrayList<Monomial> monomials = new ArrayList<Monomial>();
        monomials.add(new Monomial(3, 2));
        monomials.add(new Monomial(-4, 1));
        monomials.add(new Monomial(6, 0));

        Polynomial polynomial = new Polynomial(monomials);

        assertTrue (result.equals(polynomial));
    }

    @Test
    public void integrateTest(){
        Polynomial result = Operations.integrateOperation(polynomial1);

        ArrayList<Monomial> monomials = new ArrayList<Monomial>();
        monomials.add(new Monomial(0.25, 4));
        monomials.add(new Monomial(-0.6666666, 3));
        monomials.add(new Monomial(3.00, 2));
        monomials.add(new Monomial(-5.00, 1));

        Polynomial polynomial = new Polynomial(monomials);

        assertTrue (result.equals(polynomial));
    }
}
