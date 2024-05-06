// Source: https://leetcode.com/problems/redundant-connection/description/
package Graphs_Pkg;
import java.util.*;

class Graph_RC{
    private int vertices;
    private LinkedList<Integer>[] adj;
    int[] res = new int[2];

    public Graph_RC(int vertices){
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

    public void dfs(int src){
        HashMap<Integer, Boolean> visited = new HashMap<>();
        dfsHelper(src, visited);
    }

    public void dfsHelper(int src, HashMap<Integer, Boolean> visited){
        visited.put(src, true);

        for(int neighbor : adj[src]){
            if(!visited.containsKey(neighbor)){
                dfsHelper(neighbor, visited);
            }
            else{
                res[0] = src;
                res[1] = neighbor;
            }
        }
    }
}

public class Redundant_Connection  {
    public static int[] findRedundantConnection(int[][] edges) {
        int vertices = edges.length + 1;
        Graph_RC g = new Graph_RC(vertices);

        for(int i = 0; i < edges.length ; i++){
            g.addEdge(edges[i][0], edges[i][1], true);
        }

        g.dfs(edges[0][0]);
        return g.res;
    }

    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{2,3}};
        int[] res = findRedundantConnection(edges);

        System.out.println(Arrays.toString(res));
    }
}