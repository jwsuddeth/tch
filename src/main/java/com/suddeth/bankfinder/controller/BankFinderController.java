package com.suddeth.bankfinder.controller;

import com.suddeth.bankfinder.UI.ConsoleIO;
import com.suddeth.bankfinder.entity.Bank;
import com.suddeth.bankfinder.repository.BankRepositoryInterface;
import com.suddeth.bankfinder.service.BankFinderServiceInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BankFinderController {

    BankFinderServiceInterface service;
    BankRepositoryInterface repo;
    ConsoleIO console;

    public BankFinderController(BankRepositoryInterface repo, BankFinderServiceInterface service, ConsoleIO console){
        this.repo = repo;
        this.service = service;
        this.console = console;
    }

    public List<Bank> executeCommand(String command){

        // validate the command and use it to generate a predicate that
        // we can use to search the data
        if (service.isValidCommand(command)){

            Predicate<Bank> predicate = service.getCommand(command);

            return repo.searchBanks(predicate);
        }
        else{
            System.out.format("Error: %s is not a valid command%n", command);
        }

        return new ArrayList<>();
    }

}
