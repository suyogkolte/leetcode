// Given an input string ques, print all possible permutations of it

public class Permutations {
    public static void main(String[] args) {
        String ques = "abc";
        printPermutations(ques, "");
    }

    public static void printPermutations(String ques, String ans){
        //Base case
        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }

        for(int i = 0; i < ques.length(); i++){
            String restOFQues = ques.substring(0, i) + ques.substring(i+1);
            //i = 0 -> bc
            //i = 1 -> a + c
            //i = 2 -> ab

            printPermutations(restOFQues, ans + ques.charAt(i));
        }
    }
}
