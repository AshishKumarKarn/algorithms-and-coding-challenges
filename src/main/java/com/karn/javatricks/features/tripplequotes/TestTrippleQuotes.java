package com.karn.javatricks.features.tripplequotes;

public class TestTrippleQuotes {
    public static void main(String[] args) {
        String abc="\tMy Name is Ashish and I am experimenting \n" +
                "with new features of java.";
        String bcd = """
                    My Name is Ashish and I am experimenting 
                with new features of java.
                """;
        System.out.println(abc);
        System.out.println(bcd);
    }
}
