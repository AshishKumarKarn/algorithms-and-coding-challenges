package com.karn.nextgencoders;

import java.util.Arrays;
import java.util.List;

public class Challange41 {
	public static void main(String[] args) {
		int str = 200, dftd = 0;
		List<Integer> vlns = Arrays.asList(54, 23, 65, 87, 12);
		vlns.sort((a, b) -> a.compareTo(b));
		for (int v : vlns) {
			str = (str - v) >= 0 ? (str - v) : -1;
			if (str < 0) { System.out.println(dftd); return;}
			dftd++;
		}
		System.out.println(dftd);
	}
}