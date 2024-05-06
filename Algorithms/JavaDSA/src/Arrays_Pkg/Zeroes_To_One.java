/*
Given an input array consisting of zeroes and ones only and an integer zeroesToOne, with all ones preceding all zeroes
return the time in seconds until the operation stops

If the array has zeroesToOne number of 0 at the end then remove it and append 1 at the start
If there is 1 at the end the Convert 1 to 0

e.g.
Input 1, 1, 1, 0, 0, 0      zeroesToOne = 2

t = 0   1, 1, 1, 0, 0, 0    // Remove 0, 0 at the end and append 1 at the start
t = 1   1, 1, 1, 1, 0       // Convert 1 to 0
t = 2   1, 1, 1, 0, 0       // Remove 0, 0 at the end and append 1 at the start
t = 3   1, 1, 1, 1          // Convert 1 to 0
t = 4   1, 1, 1, 0          // Convert 1 to 0
t = 5   1, 1, 0, 0          // Remove 0, 0 at the end and append 1 at the start
t = 6   1, 1, 1             // Convert 1 to 0
t = 7   1, 1, 0             // Convert 1 to 0
t = 8   1, 0, 0             // Remove 0, 0 at the end and append 1 at the start
t = 9   1, 1                // Convert 1 to 0
t = 10   1, 0               // Convert 1 to 0
t = 11   0, 0               // Remove 0, 0 at the end and append 1 at the start
t = 12   1                  // Convert 1 to 0
t = 13   0
*/

package Arrays_Pkg;
import java.util.ArrayList;

public class Zeroes_To_One {
    public static void main(String[] args) {
        //int[] input = {1, 1, 1, 0, 0, 0};
        //int zeroesToOne = 2;
        int[] input = {1, 1};
        int zeroesToOne = 2;

        System.out.println(getTime(input, zeroesToOne));
    }

    public static int getTime(int[] input, int zeroesToOne){
        int ans = 0;

        ArrayList<Integer> list = new ArrayList<>();
        for(int num : input){
            list.add(num);
        }

        int zeroCount = 0;
        while(true){
            if(list.size() == 1 && list.get(0) == 0)
                return ans;

            while(zeroCount < zeroesToOne){
                if(list.getLast() == 0){
                    list.removeLast();
                    zeroCount++;
                }
                else {
                    list.removeLast();
                    while(zeroCount >= 0){
                        list.add(0);
                        zeroCount--;
                    }
                    break;
                }

                if(zeroCount == zeroesToOne)
                    list.addFirst(1);

            }
            zeroCount = 0;
            ans++;
        }
    }
}
