// Source: https://leetcode.com/problems/course-schedule-ii/

package Graphs_Pkg;

import java.util.*;

public class Course_Schedule_II {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
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
            return new int[0];

        int[] ans = new int[result.size()];
        for(int i = 0; i < ans.length; i++){
            ans[i] = result.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};

        int[] res = findOrder(numCourses, prerequisites);
        if(res.length > 0){
            for(int i : res){
                System.out.print(i + " ");
            }
        }
        else
            System.out.println("It is impossible to finish all courses");
    }
}