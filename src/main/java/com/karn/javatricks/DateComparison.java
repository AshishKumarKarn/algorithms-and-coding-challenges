package com.karn.javatricks;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DateComparison {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH mm ss");
        LocalDateTime date=LocalDateTime.parse("27-04-1981 00 00 00",dateTimeFormatter);
        LocalDateTime date2=LocalDateTime.parse("25-04-1991 00 00 00",dateTimeFormatter);
        Duration duration =Duration.between(date2,date);
        long days = duration.toDays();
        System.out.println(days);
    }
    private List<String> getNames(List<String> names){
        List<String> result=new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            if(names.get(i).startsWith("A")&&names.get(i).length()>3){
                result.add(names.get(i));
            }

        }
        execute(this::hello);
        return result;
    }
interface MyFunction{
        void method();
}
private void execute(MyFunction function){
        function.method();
}
    private List<String> getFilteredName(List<String> names){
        Stream<String> a = names.stream().filter(p)
                .filter(this::filterByLength);
        return a.collect(Collectors.toList());
    }



    private Boolean filterByCapitalA(String a){
        return a.startsWith("A");
    }
    private Boolean filterByLength(String a){
        return a.length()>3;
    }

    Predicate<String> p = p->p.startsWith("A");
    public void hello(){
        System.out.println("Hello");
    }

}
