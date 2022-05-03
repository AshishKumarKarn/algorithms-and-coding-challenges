package com.karn.kickstart.ks2021.roundA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

public class ChallengeNine {
    public static void main(String[] args) throws FileNotFoundException {
        //  Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Scanner sc = new Scanner(new FileInputStream("/Users/ashishkarn/Downloads/kickstart/test_data/test_set_2/ts2_input.txt"));

        int t = sc.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            BigDecimal number = sc.nextBigDecimal();
            String numberAsString = String.valueOf(number);//for easy operations
            //System.out.println(numberAsString);
            //To be a divisible by 9, the sum of the digits has to be multiple of 9
            int diff = getDiffFrom9(numberAsString);//diff from 9 is digit to be inserted
            String generatedNumber = formNumber(numberAsString, diff);
            //if the formed number has zero at beginning,it should move to 1 digit right to it.
            //Ex. 0351 should become 3051
            if (generatedNumber.charAt(0) == '0') {
                generatedNumber = generatedNumber.charAt(1) + "0" + generatedNumber.substring(2);
            }
            System.out.println("Case #" + i + ": " + generatedNumber);
        }
    }


    private static int getDiffFrom9(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            sum += number.charAt(i) - '0';
        }
        return 9 - (sum % 9);
    }

    private static String formNumber(String numberAsString, int diff) {
        String number = null;
        for (int j = 0; j < numberAsString.length(); j++) {
            if (numberAsString.charAt(j) - '0' > diff) {
                number = numberAsString.substring(0, j) + diff + numberAsString.substring(j);
                break;
            }
        }
        //it might happen that the number to be inserted is bigger than all the digits in original number
        //in that case we need to append the diff at the end(least significant digit).
        //121212120
        if (number == null) {
            number = numberAsString + diff;
        }
        return number;
    }

}
