package com.karn.algotricks.jpmc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Solution {
    //list of transaction records, unique instrument id find max, 3 -1 jan -300
    public static void main(String[] args) {

        List<Transaction> records  = getTransactions();

        long start = System.currentTimeMillis();
        Map<String, Transaction> result = new HashMap<>();
        for(Transaction transaction : records){
           if(result.containsKey(transaction.instrumentId())){
               Transaction existing = result.get(transaction.instrumentId());
               if(existing.transactionValue().compareTo(transaction.transactionValue()) <= 0){
                   result.put(transaction.instrumentId(), transaction);
               }
           }else {
               result.put(transaction.instrumentId(), transaction);
           }
        }
        System.out.println("Time take by first operation is "+ ( System.currentTimeMillis()-start)+" ms");

        result.forEach((key, value) ->
                System.out.println("Instrument: " + key + ", Transaction Value: " + value.transactionValue()));

        start = System.currentTimeMillis();
        Map<String, Transaction> result2 = records.parallelStream()
                .collect(Collectors.toMap(
                        Transaction::instrumentId,   // Key: instrumentId
                        transaction -> transaction,  // Value: transaction
                        (existing, newTransaction) ->
                                existing.transactionValue().compareTo(newTransaction.transactionValue()) <= 0
                                        ? newTransaction : existing // Keep the one with the highest transactionValue
                ));

        System.out.println("Time take by second operation is "+ ( System.currentTimeMillis()-start)+" ms");

        result2.forEach((key, value) ->
                System.out.println("Instrument: " + key + ", Transaction Value: " + value.transactionValue()));

    }

    private static List<Transaction> getTransactions() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        for (int i = 0; i < 1000_0000; i++) {
            transactions.add(new Transaction(String.valueOf(i),
                    Instrument.values()[(int)(Math.random()*3)].name(),
                    LocalDate.now(),
                    BigDecimal.valueOf(1000*Math.random())));
        }
        return transactions;
    }

}
enum Instrument {
    GOOGLE, APPLE, FACEBOOK;


}

record Transaction(String id, String instrumentId, LocalDate transactionDate, BigDecimal transactionValue) {

}
