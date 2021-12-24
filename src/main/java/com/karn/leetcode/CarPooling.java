package com.karn.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).
 * <p>
 * You are given the integer capacity and an array trips where trip[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively. The locations are given as the number of kilometers due east from the car's initial location.
 * <p>
 * Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.
 */
public class CarPooling {
    public static void main(String[] args) {
        int[][] trips = {{2, 1, 5}, {3, 3, 7}};
        int capacity = 4;
        System.out.println(new CarPooling().carPooling(trips, capacity));
    }

    public boolean carPooling(int[][] trips, int capacity) {
        int maxEast = 0;
        for(int i=0;i<trips.length;i++){
            if(trips[i][2]>maxEast){
                maxEast=trips[i][2];
            }
        }
        int[] peaks = new int[maxEast+1];
        for(int i=0;i<trips.length;i++){
            for(int j=trips[i][1];j<trips[i][2];j++){
                peaks[j]=peaks[j]+trips[i][0];
            }
        }
        for(int i=0;i<=maxEast;i++){
            if(capacity<peaks[i]){
                return false;
            }
        }
        return true;
    }
}
