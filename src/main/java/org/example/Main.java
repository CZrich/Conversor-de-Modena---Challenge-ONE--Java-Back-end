package org.example;

import api.Service;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        var api_key="6b01bc1ff1fbfe893889c714";

        //System.out.println("Hello world!");
        // Setting URL
        String url_str = "https://v6.exchangerate-api.com/v6/"+api_key+"/codes";

       ArrayList<String> code= Service.getSupportedCodes();
        System.out.println(code);
        double rate=Service.getRateConvertion("USD","PEN");
        System.out.println("rate is:"+rate);


    }
}