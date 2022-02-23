package com.karn.hashcode.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

//PracticeRound
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int clients = sc.nextInt();
        Map<String, Integer> overallLikes = new HashMap<>();
        Map<String, Integer> overallDislikes = new HashMap<>();
        List<Client> clientList = new ArrayList<>();

        for (int i = 1; i <= clients; ++i) {
//            Client client = new Client()
            Set<String> clientSpecificLikes = new HashSet<>();
            int itemsCustomerLikes = sc.nextInt();
            for (int j = 0; j < itemsCustomerLikes; j++) {
                String next = sc.next();
                Integer put = overallLikes.put(next, 1);
                if (put != null) {
                    overallLikes.put(next, (1 + put));
                }
                clientSpecificLikes.add(next);

            }
            Set<String> clientSpecificDisLikes = new HashSet<>();
            int itemsCustomerDislikes = sc.nextInt();
            for (int j = 0; j < itemsCustomerDislikes; j++) {
                String next = sc.next();
                Integer put = overallDislikes.put(next, 1);
                if (put != null) {
                    overallDislikes.put(next, (1 + put));
                }
                clientSpecificDisLikes.add(next);
            }
            Client client = new Client(i, clientSpecificLikes, clientSpecificDisLikes);
            clientList.add(client);
        }

        System.out.println("Processing...");
        long startTime = System.currentTimeMillis();
        Set<String> result = new HashSet<>(overallLikes.keySet());
        int max = getCountWithGivenIngredient(clientList, overallLikes.keySet());
        ResultSet resultSet = new ResultSet(max, result);

        getMaxResultSet(overallLikes, overallDislikes, clientList, resultSet);
        System.out.printf("Processing completed in %s ms \n", (System.currentTimeMillis() - startTime));
        System.out.println(resultSet.count);
        System.out.printf("%d", resultSet.ingredients.size());
        resultSet.ingredients.forEach(key -> System.out.printf(" %s", key));
        System.out.println();
    }

    private static void getMaxResultSet(Map<String, Integer> overallLikes, Map<String, Integer> overallDislikes, List<Client> clientList, ResultSet resultSet) {
        Set<String> pickedLikes1 = new HashSet<>();


        for (Map.Entry<String, Integer> entry : overallLikes.entrySet()) {
            Integer dis = overallDislikes.get(entry.getKey());
            if (dis == null || entry.getValue()>=(dis)) {
                pickedLikes1.add(entry.getKey());
            }
        }
        //if (pickedLikes1.size() == 0) return;

        int count = getCountWithGivenIngredient(clientList,pickedLikes1);
        if (count > resultSet.count) {
            resultSet.count = count;
            resultSet.ingredients = pickedLikes1;
        }
    }

    private static Set<Set<String>> getAllSubSetFromSet(List<String> overallDislikes) {
        int n = overallDislikes.size();
        Set<Set<String>> result = new HashSet<>();
        // Run a loop from 0 to 2^n
        for (int i = 0; i < (1 << n); i++) {
            Set<String> subResult = new HashSet<>();
            int m = 1; // m is used to check set bit in binary representation.
            // add current subset
            for (String dislike : overallDislikes) {
                if ((i & m) > 0) {
                    subResult.add(dislike);
                }
                m = m << 1;
            }
            result.add(subResult);
        }
        return result;
    }

    private final static Map<String, ResultSet> MEMORY = new HashMap<>();

    private static ResultSet getMaxCount(List<Client> clientList, Set<String> overallLikes, List<String> dislikes, int i, int j, ResultSet resultSet) {
//        System.out.printf("dislikes %s %d %d", dislikes, i,j);
//        System.out.println();
//        System.out.println(overallLikes);
        ResultSet mem1 = MEMORY.get(i + "_" + j);
        ResultSet mem2 = MEMORY.get(j + "_" + i);
        if (mem1 != null) {
            return mem1;
        }
        if (mem2 != null) {
            return mem2;
        }

        if (overallLikes.isEmpty() || i > j || i >= dislikes.size() || j < 0 || i < 0 || j >= dislikes.size()) {
            return new ResultSet(-1, null);
        }
        // System.out.println(memory);

        Set<String> tempMap1 = null;

        boolean remove1 = false;
        if (overallLikes.contains(dislikes.get(i))) {
            tempMap1 = new HashSet<>(overallLikes);
            remove1 = tempMap1.remove(dislikes.get(i));
        }
        Set<String> tempMap2 = null;
        boolean remove2 = false;
        if (overallLikes.contains(dislikes.get(j))) {
            tempMap2 = new HashSet<>(overallLikes);
            remove2 = tempMap2.remove(dislikes.get(j));
        }

        int countI = -1;
        if (remove1) {
            countI = getCountWithGivenIngredient(clientList, tempMap1);
        }
        int countJ = -1;
        if (remove2) {
            countJ = getCountWithGivenIngredient(clientList, tempMap2);
        }

        if (countI == -1 && countJ == -1) {
            ResultSet c1 = getMaxCount(clientList, resultSet.ingredients, dislikes, i + 1, j, resultSet);
            MEMORY.put(((i + 1) + "_" + j), c1);
            MEMORY.put((j + "_" + (i + 1)), c1);


            ResultSet c2 = getMaxCount(clientList, resultSet.ingredients, dislikes, i, j - 1, resultSet);
            MEMORY.put((i + "_" + (j - 1)), c2);
            MEMORY.put(((j - 1) + "_" + i), c2);
            if (c1.count > c2.count) {
                MEMORY.put((i + "_" + j), c1);
                MEMORY.put((j + "_" + i), c1);
                return c1;
            } else {
                MEMORY.put((i + "_" + j), c2);
                MEMORY.put((j + "_" + i), c2);
                return c2;
            }
        }

        ResultSet resultSet2;
        if (countI > countJ) {
            resultSet2 = new ResultSet(countI, tempMap1);
        } else {
            resultSet2 = new ResultSet(countJ, tempMap2);
        }

        ResultSet finalResult;
        if (resultSet2.count > resultSet.count) {
            finalResult = resultSet2;
        } else {
            finalResult = resultSet;
        }
        MEMORY.put(i + "_" + j, finalResult);
        MEMORY.put(j + "_" + i, finalResult);

        ResultSet maxCount1 = getMaxCount(clientList, finalResult.ingredients, dislikes, i + 1, j, finalResult);
        MEMORY.put(((i + 1) + "_" + j), maxCount1);
        MEMORY.put((j + "_" + (i + 1)), maxCount1);

        ResultSet maxCount2 = getMaxCount(clientList, finalResult.ingredients, dislikes, i, j - 1, finalResult);
        MEMORY.put((i + "_" + (j - 1)), maxCount2);
        MEMORY.put(((j - 1) + "_" + i), maxCount2);
        if (maxCount1.count > maxCount2.count) {
            MEMORY.put((i + "_" + j), maxCount1);
            MEMORY.put((j + "_" + i), maxCount1);
            return maxCount1;
        } else {
            MEMORY.put((i + "_" + j), maxCount2);
            MEMORY.put((j + "_" + i), maxCount2);
            return maxCount2;
        }

    }


    static class ResultSet {
        int count;
        Set<String> ingredients;

        ResultSet(int count, Set<String> ingredients) {
            this.count = count;
            this.ingredients = ingredients;
        }

        @Override
        public String toString() {
            return "ResultSet{" +
                    "count=" + count +
                    ", ingredients=" + ingredients +
                    '}';
        }
    }

    private static Map<String, Integer> MEMORY2 = new HashMap<>();

    private static int getCountWithGivenIngredient(List<Client> clientList, Set<String> overallLikes) {
        int count = 0;
        for (Client client : clientList) {
            boolean disliked = true;
            if (overallLikes.containsAll(client.getLikes())) {
                disliked = false;
                for (String item : client.getDislikes()) {
                    if (overallLikes.contains(item)) {
                        disliked = true;
                        break;
                    }
                }
            }
            if (!disliked) {
                ++count;
            }
        }
        return count;
    }

    static class Client {
        private final int id;
        private final Set<String> likes;
        private final Set<String> dislikes;

        public Client(int id, Set<String> likes, Set<String> dislikes) {
            this.id = id;
            this.likes = likes;
            this.dislikes = dislikes;
        }

        public int getId() {
            return id;
        }

        public Set<String> getLikes() {
            return likes;
        }

        public Set<String> getDislikes() {
            return dislikes;
        }

        @Override
        public String toString() {
            return "Client{" +
                    "id=" + id +
                    ", likesSize=" + likes.size() +
                    ", dislikesSize=" + dislikes.size() +
                    '}';
        }
    }
}