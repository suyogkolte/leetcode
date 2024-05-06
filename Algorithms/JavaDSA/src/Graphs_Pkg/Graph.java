package Graphs_Pkg;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int vertices; //   Total number of vertices possible
    private LinkedList<Integer>[] adj; //adjacency

    public Graph(int vertices){
        this.vertices = vertices;
        adj = new LinkedList[vertices];

        for(int i = 0; i < vertices; i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v, boolean bidir){
        adj[u].addFirst(v);
        if(bidir)
            adj[v].addFirst(u);
    }

    public void printAdjList(){
      for(int i = 0; i < vertices; i++){
          System.out.print(i + "->");

          for(int node : adj[i]){
              System.out.print(node + ",");
          }
          System.out.println();
      }
    }

    public void dfs(int src){
        HashMap<Integer, Boolean> visited = new HashMap<>();
        dfsHelper(src, visited);
    }

    private void dfsHelper(int src, HashMap<Integer, Boolean> visited) {
        visited.put(src, true);
        System.out.print(src + " ");
        for(int neighbor : adj[src]){
            if(!visited.containsKey(neighbor))
                dfsHelper(neighbor, visited);
        }
    }

    public void bfs(int src){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[vertices];

        q.add(src);
        visited[src] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            System.out.print(node + " ");
            for(int neighbor : adj[node]){
                if(!visited[neighbor]){
                    q.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    public int connectedComponents(){
        HashMap<Integer, Boolean> visited = new HashMap<>();
        int components = 0;

        for(int i = 0; i < vertices; i++){
            if(!visited.containsKey(i)){
                dfsHelper(i, visited);
                components++;
            }
        }
        return components;
    }

    public void shortestPath(int src, int dest){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[vertices];
        int[] parent = new int[vertices];
        int[] distance = new int[vertices];

        Arrays.fill(parent, -1);

        q.add(src);
        visited[src] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            for(int neighbor : adj[node]){
                if(!visited[neighbor]){
                    q.add(neighbor);
                    visited[neighbor] = true;
                    distance[neighbor] = distance[node] + 1;
                    parent[neighbor] = node;
                }
            }
        }

        System.out.println("Shortest distance between " + src + " and " + dest + " is " + distance[dest]);
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1, true);
        g.addEdge(1, 3, true);
        g.addEdge(1, 2, true);
        g.addEdge(0, 2, true);
        //g.printAdjList();

        //g.dfs(0);
        //g.bfs(0);

        g.addEdge(4, 5, true);
        //System.out.println("The number of connected components is " + g.connectedComponents());

        g.shortestPath(0, 3);
    }
}
