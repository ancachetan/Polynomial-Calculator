package view;

import controller.ButtonListener;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI extends JFrame{
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField text1;
    private JTextField text2;
    private JTextField text3;
    private JTextField text4;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;

    public GUI(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setTitle("Polynomial Calculator");

        this.label1 = new JLabel("First polynomial: ");
        this.label2 = new JLabel("Second polynomial: ");
        this.label3 = new JLabel("Result1: ");
        this.label4 = new JLabel("Result2: ");

        this.text1 = new JTextField(30);
        this.text2 = new JTextField(30);
        this.text3 = new JTextField(30);
        this.text4 = new JTextField(30);

        this.button1 = new JButton("Add");
        this.button2 = new JButton("Subtract");
        this.button3 = new JButton("Multiplicate");
        this.button4 = new JButton("Divide");
        this.button5 = new JButton("Derivate");
        this.button6 = new JButton("Integrate");

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel p = new JPanel();

        panel1.setLayout(new FlowLayout());
        panel2.setLayout(new FlowLayout());
        panel3.setLayout(new FlowLayout());
        panel4.setLayout(new FlowLayout());
        panel5.setLayout(new GridLayout(3, 3));
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        panel1.add(label1);
        panel1.add(text1);

        panel2.add(label1);
        panel2.add(text1);

        panel2.add(label2);
        panel2.add(text2);

        panel3.add(label3);
        panel3.add(text3);

        panel4.add(label4);
        panel4.add(text4);

        panel5.add(button1);
        panel5.add(button2);
        panel5.add(button3);
        panel5.add(button4);
        panel5.add(button5);
        panel5.add(button6);

        p.add(panel1);
        p.add(panel2);
        p.add(panel3);
        p.add(panel4);
        p.add(panel5);

        this.setContentPane(p);
        this.setVisible(true);
    }


    public void buttonActionListeners(){
        ActionListener listener1 = new ButtonListener(this.text1, this.text2, this.text3, this.text4,  this.button1);
        ActionListener listener2 = new ButtonListener(this.text1, this.text2, this.text3, this.text4,  this.button2);
        ActionListener listener3 = new ButtonListener(this.text1, this.text2, this.text3, this.text4,  this.button3);
        ActionListener listener4 = new ButtonListener(this.text1, this.text2, this.text3, this.text4,  this.button4);
        ActionListener listener5 = new ButtonListener(this.text1, this.text2, this.text3, this.text4,  this.button5);
        ActionListener listener6 = new ButtonListener(this.text1, this.text2, this.text3, this.text4,  this.button6);

        this.button1.addActionListener(listener1);
        this.button2.addActionListener(listener2);
        this.button3.addActionListener(listener3);
        this.button4.addActionListener(listener4);
        this.button5.addActionListener(listener5);
        this.button6.addActionListener(listener6);
    }
}
