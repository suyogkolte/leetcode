//Source: https://leetcode.com/problems/find-if-path-exists-in-graph/

package Graphs_Pkg;

import java.util.LinkedList;
import java.util.Queue;

public class Find_if_Path_Exists_in_Graph {
    private int vertices;
    private LinkedList<Integer>[] adj;

    public Find_if_Path_Exists_in_Graph(int vertices){
        this.vertices = vertices;
        adj = new LinkedList[vertices];

        for(int i = 0; i < vertices; i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v, boolean bidir){
        adj[u].add(v);
        if(bidir)
            adj[v].add(u);
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];

        q.add(source);
        visited[source] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            for(int neighbor : adj[node]){
                if(!visited[neighbor]){
                    q.add(neighbor);
                    visited[neighbor] = true;
                    distance[neighbor] = distance[node] + 1;
                }
            }
        }

        return distance[destination] > 0;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        //int[][] edges = {{0,1},{1,2},{2,0}};
        int source = 0, destination = 5;

        Find_if_Path_Exists_in_Graph g = new Find_if_Path_Exists_in_Graph(n);

        for(int[] edge : edges){
            g.addEdge(edge[0], edge[1], true);
        }

        if(g.validPath(n, edges, source, destination))
            System.out.println("There exists a valid path between " + source + " and " + destination);
        else
            System.out.println("There is no valid path between " + source + " and " + destination);
    }
}
