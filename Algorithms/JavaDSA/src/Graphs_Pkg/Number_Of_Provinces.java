package Graphs_Pkg;

public class Number_Of_Provinces {
    public static int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        boolean[] visited = new boolean[len];
        int res = 0;

        // loop over every node in graph
        for(int i = 0; i < len; i++){
            if(!visited[i]){
                res++;
                dfsHelper(i, isConnected, visited);
            }
        }
        return res;
    }

    public static void dfsHelper(int src, int[][] isConnected, boolean[] visited){
        visited[src] = true;

        // loopover every neighbor of the current src node
        for(int i = 0; i < isConnected.length; i++){
            if(isConnected[src][i] == 1 && !visited[i])
                dfsHelper(i, isConnected, visited);
        }
    }

    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println("The number of provinces is " + findCircleNum(isConnected));
    }
}
