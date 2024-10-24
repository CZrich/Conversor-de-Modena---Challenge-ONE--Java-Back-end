package org.example;


import ui.UserInterface;

import javax.swing.*;


public class Main {
    public static void main(String[] args)  {

        SwingUtilities.invokeLater(() -> {
            UserInterface ui = new UserInterface();
            ui.setVisible(true);
        });


    }
}