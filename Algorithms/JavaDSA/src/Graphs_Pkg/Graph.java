package Graphs_Pkg;

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Array;
import java.util.*;

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

    public boolean isBipartite(){
        // this array will store the color assigned for evey node in the graph
        int[] colors = new int[vertices];

        Arrays.fill(colors, -1); // initialise all vertices with no color

        for(int i = 0; i < vertices; i++){
            if(colors[i] == -1){
                if(!bipartitieBFS(i, colors))
                    return false; // If BFS on this component is not bipartite then return false
            }
        }
        return true; // if BFS on all components is bipartite, return true
    }

    private boolean bipartitieBFS(int src, int[] colors){
        // Two colors == 0 and 1
        Queue<Integer> q = new LinkedList<>();
        colors[src] = 0;
        q.add(src);

        while(!q.isEmpty()){
            int node = q.poll();

            for(int neighbor : adj[node]){
                if(colors[neighbor] == -1){
                    q.add(neighbor);
                    // if the neighbor has not been colored then assign the opposite color
                    colors[neighbor] = 1 - colors[node];
                }
                else if(colors[neighbor] == colors[node]){
                    // if the neighbor has same colo as the current node
                    // then the graph is not bipartite
                    return false;
                }
            }
        }

        //if the bfs traversal of this component is bipartite then return true
        return true;
    }

    // M edges
    // N nodes
    // Kahn's algo time complexity: O(M + N)
    // space complexity: O(N)
    public List<Integer> topologicalSort(){
        //Kahn's algorithm

        List<Integer> result = new ArrayList<>();

        int[] inDegree = new int[vertices];

        // calculating in-degree for all vertices: O(M)
        for(int i = 0; i < vertices; i++){
            for(int neighbor : adj[i]){
                inDegree[neighbor]++;
            }
        }

        // Create a queue to store vertices with in-degree 0: O(N)
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < vertices; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }

        // O(N)
        while(!queue.isEmpty()){
            int node = queue.poll();
            result.add(node);

            for(int neighbor : adj[node]){
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0){
                    queue.add(neighbor);
                }
            }
        }

        if(result.size() != vertices){
            //Graph has a cycle, so topological sorting is not possible
            return new ArrayList<>();
        }

        return result;
    }

    public static void main(String[] args) {
//        Graph g = new Graph(6);
//        g.addEdge(0, 1, true);
//        g.addEdge(1, 3, true);
//        g.addEdge(1, 2, true);
//        g.addEdge(0, 2, true);
        //g.printAdjList();

        //g.dfs(0);
        //g.bfs(0);

        //g.addEdge(4, 5, true);
        //System.out.println("The number of connected components is " + g.connectedComponents());

        //g.shortestPath(0, 3);
        //System.out.println(g.isBipartite());

        Graph g = new Graph(4);
        g.addEdge(0, 1, false);
        g.addEdge(1, 3, false);
        g.addEdge(1, 2, false);
        g.addEdge(0, 2, false);
        System.out.println(g.topologicalSort());
    }
}
