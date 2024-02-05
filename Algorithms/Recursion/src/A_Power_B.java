// Given 2 integer values a and b, write a recursive function to implement a power b
public class A_Power_B {
    public static void main(String[] args) {
        int a = 4;
        int b = 3;
        if(a == 0)
            System.out.println(a + " power " + b + " is " + a);
        else{
            int res = power(a, b);
            System.out.println(a + " power " + b + " is " + res);
        }
    }

    public static int power(int a, int b){
        //base case
        if(b == 0)
            return 1;

        int ans = 1;
        if(b > 0){
            //self work and recursive call
            ans = a * power(a, b - 1);
        }
        else{
            //self work and recursive call
            ans = power(a, b + 1) / a;
        }

        return ans;
    }
}
