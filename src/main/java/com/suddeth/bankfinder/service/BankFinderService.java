package com.suddeth.bankfinder.service;

import com.suddeth.bankfinder.UI.ConsoleIO;
import com.suddeth.bankfinder.entity.Bank;
import com.suddeth.bankfinder.utils.StringUtils;

import java.util.function.Predicate;

public class BankFinderService implements BankFinderServiceInterface {

    ConsoleIO console;

    public BankFinderService(ConsoleIO console){
        this.console = console;
    }

    @Override
    public boolean isValidCommand(String command) {
        if (StringUtils.isNullOrEmpty(command)){
            return false;
        }

        return command.equals("0") || command.equals("1") || command.equals("2") || command.equals("3")
                || command.equals("4") || command.equals("5") || command.equals("6")
                || command.equals("7");
    }

    @Override
    public Predicate<Bank> getCommand(String command) {

        int nCommand = Integer.parseInt(command);
        final String searchData;

        Predicate<Bank> predicate = b->false;

        switch (nCommand) {
            case 0 ->
                    // return them all
                    predicate = b -> true;
            case 1 -> {
                searchData = console.prompt("Enter Bank ID:");
                final int bankId;
                try {
                    bankId = Integer.parseInt(searchData);
                } catch (NumberFormatException ex) {

                    // they entered a bad value for the bankID.
                    // Display this message and return the default predicate
                    // which will not match anything.
                    System.out.format("Error: BankID must be numeric. %s is not numeric.%n", searchData);
                    return predicate;
                }
                predicate = b -> b.getId() == bankId;
            }
            case 2 -> {
                searchData = console.prompt("Enter Bank Name:");
                predicate = b -> b.getName().equals(searchData);
            }
            case 3 -> {
                searchData = console.prompt("Enter Bank Type:");
                predicate = b -> b.getType().equals(searchData);
            }
            case 4 -> {
                searchData = console.prompt("Enter Bank City:");
                predicate = b -> b.getCity().equals(searchData);
            }
            case 5 -> {
                searchData = console.prompt("Enter Bank State:");
                predicate = b -> b.getState().equals(searchData);
            }
            case 6 -> {
                searchData = console.prompt("Enter Bank Zipcode:");
                predicate = b -> b.getZip().equals(searchData);
            }
            case 7 -> {
                searchData = console.prompt("Enter City,State:");
                String[] fields = searchData.split(",");
                predicate = b -> b.getCity().equals(fields[0].trim()) && b.getState().equals(fields[1].trim());
            }
        }

        return predicate;
    }

}
