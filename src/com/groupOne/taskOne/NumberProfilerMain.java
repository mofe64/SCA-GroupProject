package com.groupOne.taskOne;

import javax.swing.*;

public class NumberProfilerMain {
    public static void main(String[] args) {
        NumberProfiler numberProfiler = new NumberProfiler();
        numberProfiler.setNumber(Integer.parseInt(JOptionPane.showInputDialog("Enter a number")));
         JOptionPane.showMessageDialog(null,
                numberProfiler.generateNumberProfile());
//        System.out.println( numberProfiler.generateNumberProfile());
    }
}
