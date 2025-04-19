package com.karn.javatricks.core.exceptionhandeling;

public class TryWithResourcesEnhancement {
    public static void main(String[] args) {
        System.out.println(tryMethod());
    }

    private static int tryMethod() {
        try{
            System.out.println("Executing try");
            return 5;
        }catch (Exception e){
            return 3;
        }finally {
            System.out.println("Executing finally");
            return 6;
        }
    }
}
