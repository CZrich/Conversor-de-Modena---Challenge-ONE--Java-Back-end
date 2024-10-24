package ui;

import api.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;




public class UserInterface extends JFrame {

    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;
    private JTextField inputEditable;
    private JTextField inputNoEditable;
    private JButton calculateButton;
    private JPanel jPanel;
    public UserInterface() {

        setTitle("Conversor de Moneda");
        setSize(550, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ArrayList<String> codes=Service.getSupportedCodes();
        comboBox1 = new JComboBox<>();

        comboBox2 = new JComboBox<>();
         fillComboBox(comboBox1,codes);
         fillComboBox(comboBox2,codes);
        inputEditable = new JTextField();
        inputNoEditable = new JTextField();
        inputNoEditable.setEditable(false);

        calculateButton = new JButton("Calcular");

        jPanel = new JPanel();

        jPanel.setLayout(null); // Use absolute positioning

        jPanel.setSize(450,250);

        comboBox1.setBounds(50, 30, 200, 30); // x, y, width, height
        comboBox2.setBounds(300, 30, 200, 30);

        inputEditable.setBounds(50, 80, 200, 30);
        inputNoEditable.setBounds(300, 80, 200, 30);
        inputEditable.setHorizontalAlignment(JTextField.CENTER);
        inputNoEditable.setHorizontalAlignment(JTextField.CENTER);


        calculateButton.setBounds(50, 130, 450, 40);
        // Add components to the JPanel
        jPanel.add(comboBox1);
        jPanel.add(comboBox2);
        jPanel.add(inputEditable);
        jPanel.add(inputNoEditable);
        jPanel.add(calculateButton);


        add(jPanel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double res=calcularTarifa();
                DecimalFormat df = new DecimalFormat("0.00");
                String result_formated = df.format(res);
                inputNoEditable.setText(result_formated);


                inputEditable.setText("");
            }
        });
    }

   //llena los comboBox
    private void fillComboBox(JComboBox combo,ArrayList<String> list){
        for(String code:list){
            combo.addItem(code);
        }
    }

    //se calcula la conversion
    private double calcularTarifa() {
        double result=0;
        try {
            String inputValue = inputEditable.getText();
            double amount = Double.parseDouble(inputValue);


            String base=(String)  comboBox1.getSelectedItem();
            String target = (String) comboBox2.getSelectedItem();
            double rate = Service.getRateConvertion(base,target);

            result = amount * rate;

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(this, "Por favor, ingresa un número válido.",
                    "Error de entrada", JOptionPane.ERROR_MESSAGE);
            inputEditable.setText("");
        }
        return result;
    }
}

