// source: https://leetcode.com/problems/01-matrix/description/

package Graphs_Pkg;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Zero_One_Matrix {
    // class to store the x,y co-ordinates of a point
    static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static int[][] updateMatrix(int[][] mat) {
        // declare and implement result matrix called dist
        int[][] dist = new int[mat.length][mat[0].length];

        // fill the dist matrix with ∞
        for(int i = 0; i < dist.length; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // create queue for BFS
        Queue<Point> q = new LinkedList<>();

        // find all 0's in mat,
        // set respective point in dist as 0,
        // add the point to BFS queue
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    dist[i][j] = 0;
                    q.add(new Point(i, j));
                }
            }
        }

        // four direction neighbors
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!q.isEmpty()){
            Point curr = q.poll();

            for(int i = 0; i < 4; i++){
                int newR = curr.x + dir[i][0];
                int newC = curr.y + dir[i][1];

                if(newR >= 0 && newC >= 0 && newR < mat.length && newC < mat[0].length){

                    // compare dist of neighbor with dist of curr + 1
                    if(dist[newR][newC] > dist[curr.x][curr.y] + 1){
                        dist[newR][newC] = dist[curr.x][curr.y] + 1;

                        // add neighbor to BFS queue
                        q.add(new Point(newR, newC));
                    }
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};

        int[][] res = new int[mat.length][mat[0].length];
        res = updateMatrix(mat);

        for(int i = 0; i < res.length; i++){
            for(int j = 0; j < res[0].length; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
