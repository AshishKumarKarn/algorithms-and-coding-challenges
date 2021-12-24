package com.karn.quora;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;

import static com.karn.quora.DayTest.WeekDay.getDay;
public class DayTest {
    public static void main(String[] args) {
        System.out.println(WeekDay.MON == getDay("Sunday"));
    }
    enum WeekDay{
        MON("Monday"),TUE("Tuesday");
        private final String day;
        WeekDay(String day){
            this.day = day;
        }
        public static WeekDay getDay(String day){
            WeekDay[] values = WeekDay.values();
            Arrays.sort(values, Comparator.comparing(c -> c.day));
            int[] vals={1,3,4};
            OptionalInt max = Arrays.stream(vals).max();
            int asInt = max.getAsInt();
            Arrays.stream(values).max(Comparator.comparing(a -> a.day)).get();
            Optional<WeekDay> first = Arrays.stream(values).filter(d -> d.day.equals(day)).findAny();
            return first.orElseThrow(()->new IllegalArgumentException("Invalid day"));

        }
    }

}
