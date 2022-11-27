package com.company;

import javax.swing.*;

public class BMI {
    private JTextField nameField;
    private JTextField weightField;
    private JTextField heightField;
    private JButton OKButton;
    private JPanel BMIPanel;

    public BMI() {
        JFrame frame = new JFrame("BMI Calculator");
        frame.setContentPane(BMIPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(300, 400);
        frame.setVisible(true);

        OKButton.addActionListener(e -> {
            String name = nameField.getText();

            // Check if weight and height text fields are empty, continue if not
            if (!weightField.getText().equals("") && !heightField.getText().equals("")) {

                // Get BMI and Remarks
                float weight = Float.parseFloat(weightField.getText());
                float height = Float.parseFloat(heightField.getText());
                float BMI = computeBMI(height, weight);
                String remarks = getRemarks(BMI);

                // Clear inputs
                nameField.setText("");
                weightField.setText("");
                heightField.setText("");

                // Open results window
                new Results(BMI, remarks, name);
            }
        });
    }

    public static float computeBMI(float height, float weight) {
        return weight / (height * height);
    }

    public static String getRemarks(float BMI) {
        if (BMI <= 18.5) {
            return "Your Classification is Underweight.";
        } else if (BMI <= 25.0) {
            return "Your Classification is Normal.";
        } else if (BMI <= 30.0) {
            return "Your Classification is Overweight.";
        } else {
            return "Your Classification is Obese.";
        }
    }
}