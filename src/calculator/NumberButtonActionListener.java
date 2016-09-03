/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 5399
 */
public class NumberButtonActionListener implements ActionListener{
    
    public int number;       //number on the button
    public CalculatorUI ui;  //ui class we were building

    public NumberButtonActionListener(int number, CalculatorUI ui) {
        this.number = number;
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ui.rightnum += number; //buid uo the rightnum string
        ui.updateGUI();
        
        
 
    
    }
}
