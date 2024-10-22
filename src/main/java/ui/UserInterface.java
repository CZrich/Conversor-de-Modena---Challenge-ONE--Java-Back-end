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

    public UserInterface() {

        setTitle("Currency Converter");
        setSize(800, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana
        setLayout(new GridLayout(3, 2)); // Usar un GridLayout para organizar los componentes

        // Inicializar componentes
        ArrayList<String> codes=Service.getSupportedCodes();
        comboBox1 = new JComboBox<>(); // Ejemplo de códigos de moneda

        comboBox2 = new JComboBox<>(); // Ejemplo de tarifas (USD a otras monedas)
         fillComboBox(comboBox1,codes);
         fillComboBox(comboBox2,codes);
        inputEditable = new JTextField();
        inputNoEditable = new JTextField();
        inputNoEditable.setEditable(false); // Hacer el campo no editable

        calculateButton = new JButton("Calcular");

        // Agregar componentes al JFrame
        add(comboBox1);
        add(comboBox2);
        add(inputEditable);
        add(inputNoEditable);
        add(calculateButton);

        // Manejar el evento del botón
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularTarifa();
            }
        });
    }

    private void fillComboBox(JComboBox combo,ArrayList<String> list){
        for(String code:list){
            combo.addItem(code);
        }
    }
    private void calcularTarifa() {
        try {
            String inputValue = inputEditable.getText();
            double amount = Double.parseDouble(inputValue);


            String base=(String)  comboBox1.getSelectedItem();
            String target = (String) comboBox2.getSelectedItem();
            double rate = Service.getRateConvertion(base,target);


            double result = amount * rate;
            DecimalFormat df = new DecimalFormat("#.00");
            String result_formated = df.format(result);

            inputNoEditable.setText(result_formated);


            inputEditable.setText("");

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(this, "Por favor, ingresa un número válido.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
            inputEditable.setText("");
        }

    }
}

