// Source: https://leetcode.com/problems/course-schedule/description/

package Graphs_Pkg;

import java.util.*;

public class Course_Schedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> result = new ArrayList<>();

        // Calc the adj list
        LinkedList<Integer>[] adj = new LinkedList[numCourses];
        for(int i = 0; i < numCourses; i++){
            adj[i] = new LinkedList<>();
        }

        for(int i = 0; i < prerequisites.length; i++){
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        // Calc the indegree
        int[] inDegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            for(int neighbor : adj[i]){
                inDegree[neighbor]++;
            }
        }

        // Create a queue to store vertices with in-degree 0
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0)
                q.add(i);
        }

        // BFS
        while(!q.isEmpty()){
            int node = q.poll();
            result.add(node);

            for(int neighbor : adj[node]){
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0)
                    q.add(neighbor);
            }
        }

        if(result.size() != numCourses)
            return false;

        return true;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};

        if(canFinish(numCourses, prerequisites))
            System.out.println("You can finish all courses");
        else
            System.out.println("You cannot finish all courses");
    }
}
