package com.suddeth.bankfinder.repository;

import com.suddeth.bankfinder.entity.Bank;
import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

public interface BankRepositoryInterface {
    void loadData(String filePath) throws IOException;
    List<Bank> searchBanks(Predicate<Bank> predicate);
}
