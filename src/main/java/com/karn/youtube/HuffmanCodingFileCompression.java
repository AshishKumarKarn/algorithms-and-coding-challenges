package com.karn.youtube;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HuffmanCodingFileCompression {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc=new Scanner(new FileInputStream("uncompresssedfile.txt"));
        String string = sc.nextLine();
new HuffmanCodingFileCompression().compress(string);
    }
    public BitSet compress(String string){
        char[] chars = string.toCharArray();
        Map<Character, Integer> map=new HashMap<>();
        for (char c:chars) {
            Integer put = map.put(c, 1);
            if(put!=null){
                map.put(c, put+1);
            }
        }
        System.out.println(map);
        Stream<Map.Entry<Character, Integer>> sorted1 = map.entrySet().stream().sorted(Map.Entry.comparingByValue());
        Set<Map.Entry<Character, Integer>> collect = sorted1.collect(Collectors.toSet());
        return null;
    }
    static class CharacterTree{
        Node rootNode;
        public BitSet getEncoded(char c){
            return null;
        }
    }
    static class Node{
        Node left;
        Node right;
        char c;
        int value;
    }
}
