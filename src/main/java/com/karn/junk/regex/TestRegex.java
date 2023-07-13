package com.karn.junk.regex;

import java.util.regex.Pattern;

public class TestRegex {
    public static void main(String[] args) {
        String string = "0";
        String zeroTo255 = "(((0|1)?[0-9]?[0-9])|(2?[0-4]?[0-9])|(2?5?[0-5]))";
        String ipRegex = "^"+zeroTo255+"\\."+zeroTo255+"\\."+zeroTo255+"\\."+zeroTo255+"$";
        String ip = "000.12.12.034";
       // System.out.println(matches(regex, string));
        System.out.println(matches(ipRegex, ip));
        Pattern regex = Pattern.compile("", Pattern.CASE_INSENSITIVE);

    }

    public static boolean matches(String regex, String string) {
        return string.matches(regex);
    }
}
