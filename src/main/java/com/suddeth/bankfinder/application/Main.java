package com.suddeth.bankfinder.application;

import com.suddeth.bankfinder.UI.ConsoleIO;
import com.suddeth.bankfinder.entity.Bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.suddeth.bankfinder.controller.BankFinderController;
import com.suddeth.bankfinder.repository.*;
import com.suddeth.bankfinder.service.BankFinderService;
import com.suddeth.bankfinder.service.BankFinderServiceInterface;

public class Main {

    public static void main(String ...argv){

        if (argv.length != 1){
            System.out.println("Usage: java BankFinderService CompletePathToDataFile");
            return;
        }

        // create my UI for input, which is the console
        ConsoleIO console = new ConsoleIO(new BufferedReader(new InputStreamReader(System.in)));

        // create repository and service layers
        BankRepositoryInterface repo = new BankRepository();
        BankFinderServiceInterface service = new BankFinderService(console);

        try{
            repo.loadData(argv[0]);

            // create the controller
            BankFinderController controller = new BankFinderController(repo, service, console);

            // read commands. Each command would
            String command = console.prompt();
            while(!command.equalsIgnoreCase("exit")){

                // get the search results
                List<Bank> searchResults = controller.executeCommand(command);

                // print them out
                if (searchResults.isEmpty()){
                    System.out.println("No results were found\n");
                }
                else{
                    searchResults.forEach(System.out::println);
                    System.out.println();
                }

                // prompt for the next command
                command = console.prompt();
            }
        }
        catch(IOException ex){
            System.out.format("Failed to load file %s", argv[0]);
            ex.printStackTrace();
        }

    }
}
