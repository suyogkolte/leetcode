package Arrays_Pkg;

public class Reorganize_String{
    public static void main(String[] args) {
        String s = "aab";
        System.out.println("The reorganised string is: " + reorganiseString(s));
    }

    private static String reorganiseString(String s) {
        // Parse the input string and get freq of each char
        int[] hash = new int[26];
        for(int i = 0; i < s.length(); i++){
            int idx = s.charAt(i) - 'a';
            hash[idx]++;
        }

        // Find the char in hash table with max freq
        int maxFreq = 0;
        int letter = 0;
        for(int i = 0; i < hash.length; i++){
            if(hash[i] > maxFreq){
                maxFreq = hash[i];
                letter = i;
            }
        }

        // If freq of char with max occurrence is greater than
        // half of input string then return ""
        //s.length()+1 to take into account odd length of input
        if(maxFreq > (s.length() + 1)/2)
            return "";

        char[] res = new char[s.length()];

        // Fill all even places of res[] with majority char
        int idx = 0;
        while(hash[letter]-- > 0){
            res[idx] = (char)(letter + 'a');
            idx += 2;
        }

        // Fill remaining chars from hashtable into res
        for(int i = 0; i < hash.length; i++){
            while(hash[i]-- > 0){
                if(idx >= res.length)
                    idx = 1;

                res[idx] = (char)(i + 'a');
                idx += 2;
            }
        }
        return String.valueOf(res);
    }
}