package com.karn.javatricks.concurrency;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MapResearchDemo {
    public static void main(String[] args) {
        ConcurrentHashMap map=new ConcurrentHashMap();
        Set set=new HashSet();
        set.add(1);
//        set.add(4);
//        set.add(2);
        for (Object o:set){
            set.add(3);
        }
    }
}
