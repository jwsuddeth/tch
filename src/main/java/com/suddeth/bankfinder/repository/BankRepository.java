package com.suddeth.bankfinder.repository;

import java.util.*;
import java.io.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import com.suddeth.bankfinder.entity.Bank;

public final class BankRepository implements BankRepositoryInterface {

    // hold the data from the file
    private final List<Bank> bankList = new ArrayList<>();

    @Override
    public void loadData(String filePath) throws IOException {


        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        // read the header line. We don't use it though.
        reader.readLine();

        // read first data row
        String line = reader.readLine();
        while (line != null && !line.isEmpty()){

            String [] fields = line.split(",");
            bankList.add(
                    new Bank()
                            .setId(Integer.parseInt(fields[0]))
                            .setName(fields[1])
                            .setType(fields[2])
                            .setCity(fields[3])
                            .setState(fields[4])
                            .setZip(fields[5])
                    );

            line = reader.readLine();
        }
    }

    @Override
    public List<Bank> searchBanks(Predicate<Bank> predicate){
        return bankList.stream().filter(predicate).collect(Collectors.toList());
    }
}
