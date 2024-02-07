//Calculate n factorial

public class N_Factorial {
    public static void main(String[] args) {
        int n = 2;
        int res = calcFactorial(n);
        System.out.println(n + " factorial is " + res);
    }

    public static int calcFactorial(int n){
        //Base condition
        if(n <= 1)
            return 1;

        //Recursion
        int tmp = calcFactorial(n - 1);

        //Self work
        return n * tmp;
    }
}
