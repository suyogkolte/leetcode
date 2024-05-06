// Given 2 integer values a and b, write a recursive function to implement a power b
package Recursion_Pkg;
public class A_Power_B {
    public static void main(String[] args) {
        float res = 0;
        int a = 3;
        int b = -3;

        if(a == 0)
            System.out.println(a + " power " + b + " is " + a);
        else{
            res = power(a, b);
            if(b > 0)
                System.out.println(a + " power " + b + " is " + res);
            else{
                res = 1 / power(a, b);
                System.out.println(a + " power " + b + " is " + res);
            }

        }
    }

    public static float power(int a, int b){
        //base case
        if(b == 0)
            return 1;

        float ans = 1;
        if(b > 0){
            //self work and recursive call
            ans = a * power(a, b - 1);
        }
        else{
            //self work and recursive call
            ans = a * power(a, b + 1);
        }

        return ans;
    }
}
