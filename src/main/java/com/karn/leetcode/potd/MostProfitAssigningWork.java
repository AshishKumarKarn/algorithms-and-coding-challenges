package com.karn.leetcode.potd;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class MostProfitAssigningWork {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);
        List<Task> taskPro = new ArrayList<>();
        for (int i = 0; i < difficulty.length; i++) {
            Task task = new Task(difficulty[i], profit[i]);
            taskPro.add(task);
        }
        int maxProfit = 0;
        taskPro.sort((t1, t2) -> t2.profit.compareTo(t1.profit));
        outer:
        for (int i = worker.length - 1; i >= 0; i--) {
            while (!taskPro.isEmpty()) {
                Task task = taskPro.get(0);
                if (task.difficulty <= worker[i]) {
                    maxProfit += task.profit;
                    continue outer;
                } else {
                    taskPro.remove(0);
                }
            }
        }
        return maxProfit;
    }

    static class Task {
        Integer difficulty;
        Integer profit;

        Task(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }
    }
}
