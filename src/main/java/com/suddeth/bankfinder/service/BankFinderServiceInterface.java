package com.suddeth.bankfinder.service;

import com.suddeth.bankfinder.entity.Bank;

import java.util.function.Predicate;

public interface BankFinderServiceInterface {
    boolean isValidCommand(String command);
    Predicate<Bank> getCommand(String command);
}
