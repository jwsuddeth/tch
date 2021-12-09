package com.suddeth.bankfinder.UI;

import java.io.BufferedReader;
import java.io.IOException;

public class ConsoleIO {

    BufferedReader reader;
    public ConsoleIO(BufferedReader reader){
        this.reader = reader;
    }

    public String prompt(){
        System.out.println("Choose Option:");
        System.out.println("0 for ALL Banks");
        System.out.println("1 to search by Bank ID");
        System.out.println("2 to search by Bank Name");
        System.out.println("3 to search by Bank Type");
        System.out.println("4 to search by Bank City");
        System.out.println("5 to search by Bank State");
        System.out.println("6 to search by Bank Zip");
        System.out.println("7 to search by City,State");
        System.out.println("Or enter \"Exit\" to exit the program.");

        return readResponse();
    }

    public String prompt(String msg){
        System.out.println(msg);
        return readResponse();
    }

    public String readResponse(){

        String response;
        try{
            response = reader.readLine();
        }
        catch(IOException ex){
            System.out.format("Error reading user input %s%n", ex.getMessage());
            response = "exit";
        }

        return response;
    }

}
