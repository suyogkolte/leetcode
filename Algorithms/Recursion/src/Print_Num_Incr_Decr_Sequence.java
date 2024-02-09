/*
Take as input N, a number.
Print odd numbers in decreasing sequence (up until 0) and even numbers in increasing sequence (up until N)
e.g. I/P: for N = 6
     O/P: 5, 3, 1, 2, 4
*/

import java.util.ArrayList;

public class Print_Num_Incr_Decr_Sequence {
    public static void main(String[] args) {
        int N = 6;
        ArrayList<Integer> listOdd = new ArrayList<>();
        ArrayList<Integer> listEven = new ArrayList<>();
        printNums(N, listOdd, listEven);

        for(Integer num : listOdd){
            System.out.print(num + " ");
        }
        for(Integer num : listEven){
            System.out.print(num + " ");
        }
    }

    private static void printNums(int num, ArrayList<Integer> listOdd,  ArrayList<Integer> listEven){
        //Base case
        if(num  == 0)
            return;

        //Self work
        if(num % 2 == 0)
            listEven.addFirst(num);
        else
            listOdd.add(num);

        //Recursive task
        printNums(num - 1, listOdd, listEven);
    }
}
