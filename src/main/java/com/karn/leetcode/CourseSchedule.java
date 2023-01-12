package com.karn.leetcode;


import java.util.LinkedList;

public class CourseSchedule {
    int[] visited;
    int[] cyclicVisit;


    //     {{0,1},{1,2},{1,0}};
    //   u<-v  u<-v  u <-v
    public boolean canFinish(int numCourses, int[][] p) {
        LinkedList<Integer>[] ajList = new LinkedList[numCourses];
        for (int[] edges : p) {
            int u = edges[0];
            int v = edges[1];
            LinkedList<Integer> vertex = ajList[v];
            if (vertex == null) {
                vertex = new LinkedList<>();
            }
            vertex.add(u);
            ajList[v] = vertex;
        }
        for (int i = 0; i < ajList.length; i++) {
            if(ajList[i]==null){
                ajList[i]=new LinkedList<>();
            }
        }
        visited = new int[numCourses];
        cyclicVisit = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {

            if (visited[i] == 0) {
                boolean dfs = dfs(ajList, visited, cyclicVisit, i, true);
                if(!dfs){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(LinkedList<Integer>[] ajList, int[] visited, int[] cyclicVisit, int i, boolean result) {
        if (visited[i] == 1 && cyclicVisit[i] == 1) {
            return false;
        }
        cyclicVisit[i] = 1;
        visited[i] = 1;
        LinkedList<Integer> vertexList = ajList[i];
        for (Integer integer : vertexList) {
                 result = dfs(ajList, visited, cyclicVisit, integer, result);
                 if(!result){
                     return false;
                 }
        }
        cyclicVisit[i]=0;
        return true;
    }
}
