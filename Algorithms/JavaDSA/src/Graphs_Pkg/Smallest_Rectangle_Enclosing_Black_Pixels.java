//Source: https://leetcode.com/problems/smallest-rectangle-enclosing-black-pixels/

package Graphs_Pkg;

import java.util.*;

public class Smallest_Rectangle_Enclosing_Black_Pixels {
        static int minX = 0, maxX = 0, minY = 0, maxY = 0;

        static class Point{
            int a;
            int b;

            public Point(int a, int b){
                this.a = a;
                this.b = b;
            }
        }

        public static int minArea(char[][] image, int x, int y) {
            // Resetting variables for Leetcode
            minX = 0;
            maxX = 0;
            minY = 0;
            maxY = 0;

            int rows = image.length;
            int cols = image[0].length;

            if(rows == 0 || cols == 0)
                return 0;

            // BFS queue
            Queue<Point> q = new LinkedList<>();
            image[x][y] = '-';
            q.add(new Point(x, y));
            minX = rows - 1;
            minY = cols - 1;

            int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            while(!q.isEmpty()){
                Point curr = q.poll();
                minX = Math.min(minX, curr.a);
                maxX = Math.max(maxX, curr.a);
                minY = Math.min(minY, curr.b);
                maxY = Math.max(maxY, curr.b);


                for(int i = 0; i < 4; i++){
                    int newR = curr.a + dir[i][0];
                    int newC = curr.b + dir[i][1];

                    if(newR >= 0 && newR < rows && newC >= 0 && newC < cols && image[newR][newC] == '1'){
                        image[newR][newC] = '-';
                        q.add(new Point(newR, newC));
                    }
                }
            }
            return (maxX - minX + 1) * (maxY - minY + 1);
        }

    public static void main(String[] args) {
        char[][] image = {{'0','0','1','0'},{'0','1','1','0'},{'0','1','0','0'}};
        int x = 0, y = 2;

        System.out.println("The area of the smallest (axis-aligned) rectangle that encloses all black pixels is " + minArea(image, x, y));
    }
}
