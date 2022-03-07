package com.karn.leetcode;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class LongestConsecutiveSequenceTest {
    LongestConsecutiveSequence object=new LongestConsecutiveSequence();

    @Test
    public void longestConsecutive() throws FileNotFoundException {
        Scanner sc=new Scanner(new FileInputStream("LongestConsecutiveSequenceTest.txt"));
        StringBuilder sb=new StringBuilder();
        while (sc.hasNext()){
            sb.append(sc.next());
        }
        String[] split = sb.toString().split(",");
        int[] ints = Arrays.stream(split).mapToInt(Integer::valueOf).toArray();
        int result = object.longestConsecutive(ints);


    }

    @Test
    public void longestConsecutive2() throws FileNotFoundException {

        int[] ints = {1,2,3,4,1};
        int result = object.longestConsecutive(ints);
        System.out.println(result);


    }
}