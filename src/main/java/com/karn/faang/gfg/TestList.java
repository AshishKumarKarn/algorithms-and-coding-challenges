package com.karn.faang.gfg;


import java.util.List;

public class TestList {
    public static void main(String[] args) {
        List<String> names = List.of("Ashish", "Shantanu");
        WriteEssay writeEssay = new WriteEssayImpl();
        writeEssay.write();

        WriteEssay writeEssay1 = new WriteEssay() {
            @Override
            public void write() {
                System.out.println("Through Inner class");
            }
        };
        writeEssay1.write();

        WriteEssay writeEssay2 = () -> System.out.println("Through lambda 2");
        writeEssay2.write();

        WriteEssay writeEssay3 = AnotherClass::abcd;
       writeEssay3.write();


    }

    //composition, aggregation, association.

    //S - SRP--> GOD anti-pattern.
    //O - Open Close ->
    //L - LSP -Liskov Substituion
    //I - Interface Segregation -> ColorPrinter -> ColorPrint() B BWPrint()
    //D - Dependency Inversion <-> HighLevelModule <-> LLM
}
@FunctionalInterface
interface WriteEssay {
    void write();
}
class WriteEssayImpl implements WriteEssay {

    @Override
    public void write() {
        System.out.println("through WriteEssayImpl");
    }
}
class AnotherClass {
    public static void abcd(){
        System.out.println("abcd");
    }
}