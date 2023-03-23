package controller;

import model.Operations;
import model.Polynomial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonListener implements ActionListener {
    private JTextField tfP1;
    private JTextField tfP2;
    private JTextField tfResult1;
    private JTextField tfResult2;
    private JButton button;

    public ButtonListener(JTextField tfP1, JTextField tfP2, JTextField result1, JTextField result2, JButton button) {
        this.tfP1 = tfP1;
        this.tfP2 = tfP2;
        this.tfResult1 = result1;
        this.tfResult2 = result2;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pol1 = tfP1.getText();
        String pol2 = tfP2.getText();

        Polynomial polynomial1 = Polynomial.getPolynomial(pol1);
        Polynomial polynomial2 = Polynomial.getPolynomial(pol2);
        Polynomial polynomial = new Polynomial(new ArrayList<>());

        String buttonName = button.getText();

        if (buttonName.equals("Add")){
           polynomial =  Operations.addOperation(polynomial1, polynomial2);
            tfResult1.setText(polynomial + " ");
            tfResult2.setText(" ");
        } else if (buttonName.equals("Subtract")){
           polynomial = Operations.subtractOperation(polynomial1, polynomial2);
            tfResult1.setText(polynomial + " ");
            tfResult2.setText(" ");
        } else if (buttonName.equals("Multiplicate")){
           polynomial = Operations.multiplicateOperation(polynomial1, polynomial2);
            tfResult1.setText(polynomial + " ");
            tfResult2.setText(" ");
        } else if (buttonName.equals("Divide")){
           ArrayList<Polynomial> polynomialList = Operations.divideOperation(polynomial1, polynomial2);
           tfResult1.setText(polynomialList.get(0) + " ");
           tfResult2.setText(polynomialList.get(1) + " ");
        } else if (buttonName.equals("Derivate")){
           polynomial = Operations.derivateOperation(polynomial1);
            tfResult1.setText(polynomial + " ");
            tfResult2.setText(" ");
        } else if (buttonName.equals("Integrate")){
           polynomial = Operations.integrateOperation(polynomial1);
            tfResult1.setText(polynomial + " ");
            tfResult2.setText(" ");
        }
    }
}
