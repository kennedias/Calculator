/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author 5399
 */
public class CalculatorUI {
    JFrame frame;
    JTextArea infoPanel;
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    JButton btnPlus, btnMinus, btnDivision, btnMultiply;
    JButton btnClear, btnEquals;
    
    JPanel middlePanel, bottomPanel;
    
    double total = 0;
    String leftnum ="", rightnum="";
    String operator="";
    
    void setupUI(){
        frame = new JFrame("My awesome calculator");
        frame.setSize(300,300);
        infoPanel = new JTextArea();
        infoPanel.setEditable(true); //cant type in there
        frame.add(infoPanel, BorderLayout.NORTH);
        
        setupButtons();
        setupPanels();
        
        frame.setVisible(true);
        
    }
    
    private void setupPanels(){
        middlePanel = new JPanel(new GridLayout(5,3));
        bottomPanel = new JPanel(new GridLayout(1,2));
        middlePanel.add(btn1);
        middlePanel.add(btn2);
        middlePanel.add(btn3);
        middlePanel.add(btn4);
        middlePanel.add(btn5);
        middlePanel.add(btn6);
        middlePanel.add(btn7);
        middlePanel.add(btn8);
        middlePanel.add(btn9);
        middlePanel.add(btn0);
        middlePanel.add(btnPlus);
        middlePanel.add(btnMinus);
        middlePanel.add(btnDivision);
        middlePanel.add(btnMultiply);
        bottomPanel.add(btnClear);
        bottomPanel.add(btnEquals);

        frame.add(middlePanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);       
        
    }
    
    private void setupButtons(){
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btn7 = new JButton("7");
        btn8 = new JButton("8");
        btn9 = new JButton("9");
        btn0 = new JButton("0");
        btnPlus = new JButton("+");
        btnMinus = new JButton("-");
        btnDivision = new JButton("/");
        btnMultiply = new JButton("*");
        btnClear = new JButton("clr");
        btnEquals = new JButton("=");
        
        //TODO button action listeners
        btn1.addActionListener(new NumberButtonActionListener(1, this));
        btn2.addActionListener(new NumberButtonActionListener(2, this));
        btn3.addActionListener(new NumberButtonActionListener(3, this));
        btn4.addActionListener(new NumberButtonActionListener(4, this));
        btn5.addActionListener(new NumberButtonActionListener(5, this));
        btn6.addActionListener(new NumberButtonActionListener(6, this));
        btn7.addActionListener(new NumberButtonActionListener(7, this));
        btn8.addActionListener(new NumberButtonActionListener(8, this));        
        btn9.addActionListener(new NumberButtonActionListener(9, this));
        btn0.addActionListener(new NumberButtonActionListener(0, this));

        btnPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leftnum = rightnum;
                rightnum = "";
                operator = "+";
                updateGUI();
            }
        });

        btnMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leftnum = rightnum;
                rightnum = "";
                operator = "-";
                updateGUI();
            }
        });
        
        btnDivision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leftnum = rightnum;
                rightnum = "";
                operator = "/";
                updateGUI();
            }
        });
        
        btnMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leftnum = rightnum;
                rightnum = "";
                operator = "*";
                updateGUI();
            }
        }); 
 
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leftnum = "";
                rightnum = "";
                operator = "";
                total=0;
                infoPanel.setText("");
                updateGUI();
            }
        });         
        
        btnEquals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!leftnum.isEmpty()&&!rightnum.isEmpty()&&!operator.isEmpty()){
                    switch (operator) {
                        case "+":  
                            total=Double.parseDouble(leftnum) + Double.parseDouble(rightnum);
                            updateGUI();
                            //keep total in left for further arithmetic
                            leftnum = ""+total;
                            rightnum = ""+total;
                            infoPanel.setText(infoPanel.getText()+"\n="+total);                            
                            break;
                        case "-":  
                            total=Double.parseDouble(leftnum) - Double.parseDouble(rightnum);
                            updateGUI();
                            //keep total in left for further arithmetic
                            leftnum = ""+total;
                            rightnum = ""+total;
                            infoPanel.setText(infoPanel.getText()+"\n="+total);                            
                            break;
                        case "/":  
                            total=Double.parseDouble(leftnum) / Double.parseDouble(rightnum);
                            updateGUI();
                            //keep total in left for further arithmetic
                            leftnum = ""+total;
                            rightnum = ""+total;
                            infoPanel.setText(infoPanel.getText()+"\n="+total);                            
                            break;
                        case "*":  
                            total=Double.parseDouble(leftnum) * Double.parseDouble(rightnum);
                            updateGUI();
                            //keep total in left for further arithmetic
                            leftnum = ""+total;
                            rightnum = ""+total;
                            infoPanel.setText(infoPanel.getText()+"\n="+total);                            
                            break;
                    }
                }
            }
        });
    }
    
    public void updateGUI(){
        String output = leftnum+" "+operator+" "+rightnum;
        infoPanel.setText(output);
    }
}
