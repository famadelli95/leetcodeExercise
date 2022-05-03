public class Exercise005LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        String longestPalindromicSubstring = "";
        int range;

        //first method searching for a odd substring, so starting from the middle point
        for(int index = 0; index < s.length(); index++){
            for(range = 0; index - range - 1 >= 0 && index + range + 1 < s.length(); range++){
                //if the chars at the edges of the range are different it stops
                if(s.charAt(index-range-1) != s.charAt(index+range+1))
                    break;
            }
            if(longestPalindromicSubstring.length() < 1 + 2 * range)
                longestPalindromicSubstring = s.substring(index-range,index+range+1);
        }

        //secondo method searching for a even substring, so starting from the two chars in the middle
        for(int index = 0; index < s.length()-1; index++){
            if(s.charAt(index) == s.charAt(index+1)) {
                for (range = 0; index - range - 1 >= 0 && index + range + 2 < s.length(); range++) {
                    //if the chars at the edges of the range are different it stops
                    if (s.charAt(index - range - 1) != s.charAt(index + range + 2))
                        break;
                }
                if (longestPalindromicSubstring.length() < 2 + 2 * range)
                    longestPalindromicSubstring = s.substring(index-range,index+range+2);
            }
        }

        return longestPalindromicSubstring;
    }

    public static void main(String[] args) {
        String s = "";
        Exercise005LongestPalindromicSubstring test = new Exercise005LongestPalindromicSubstring();
        String palindromic = test.longestPalindrome(s);
        System.out.println(palindromic);
    }
}
