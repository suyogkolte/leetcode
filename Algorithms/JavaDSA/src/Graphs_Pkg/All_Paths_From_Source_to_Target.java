// Source: https://leetcode.com/problems/all-paths-from-source-to-target/description/

package Graphs_Pkg;
import java.lang.reflect.Array;
import java.util.*;

class All_Paths_From_Source_to_Target {
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);
        dfs(graph, 0, res, path);

        return res;
    }

    private static void dfs(int[][] graph, int node, List<List<Integer>> res, List<Integer> path){
        //Base case
        if(node == graph.length - 1){
            res.add(new ArrayList<Integer>(path));
            //res.add(path);
            return;
        }

        for(int nextNode: graph[node]){
            //do
            path.add(nextNode);

            //recurse
            dfs(graph, nextNode, res, path);

            //undo
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}};
        List<List<Integer>> res = allPathsSourceTarget(graph);

        System.out.println(res);
    }
}