package com.karn.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Leetcode 502
 */
public class IPO {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Queue<Project> projects = new PriorityQueue<>(Comparator.comparing(a -> a.capital));
        for (int i = 0; i < profits.length; i++) {
            projects.add(new Project(profits[i], capital[i]));
        }

        Queue<Project> maxProfitProjects = new PriorityQueue<>((a, b) -> b.profit.compareTo(a.profit));

        for (int i = 0; i < k; i++) {
            while (!projects.isEmpty() && projects.peek().capital <= w) {
                maxProfitProjects.add(projects.poll());
            }

            if (maxProfitProjects.isEmpty()) {
                break;
            }

            w += maxProfitProjects.poll().profit;
        }

        return w;
    }

    static class Project {
        Integer profit;
        Integer capital;

        Project(Integer p, Integer c) {
            this.profit = p;
            this.capital = c;
        }
    }


}
