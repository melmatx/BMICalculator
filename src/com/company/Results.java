package com.company;

import javax.swing.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Results {
    private JLabel nameLabel;
    private JLabel bmiLabel;
    private JLabel remarksLabel;
    private JPanel ResultsPanel;

    public Results(float BMI, String remarks, String name) {

        // Round up BMI to two decimal places
        DecimalFormat df = new DecimalFormat("##.#");
        df.setRoundingMode(RoundingMode.CEILING);

        // Set results to text labels
        nameLabel.setText("Name: " + name);
        bmiLabel.setText("BMI: " + df.format(BMI));
        remarksLabel.setText(remarks);

        JFrame frame = new JFrame("Results");
        frame.setContentPane(ResultsPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(300, 150);
        frame.setVisible(true);
    }
}