import java.util.Hashtable;

class Exercise003 {
    int lengthOfLongestSubstring(String s) {
        int max = 0;
        int startOfLastRepeat = 0;
        //the table saves the position of the char
        Hashtable<Character,Integer> charPosition = new Hashtable<>();
        int i = 0;

        for(; i < s.length() ; i++){

            //if the char already exist and it was not before the last repeated char
            if(charPosition.containsKey(s.charAt(i)) && charPosition.get(s.charAt(i)) >= startOfLastRepeat){
                if(i-startOfLastRepeat > max)
                    max = i-startOfLastRepeat;

                //we start to count now one index after the last repeated found
                startOfLastRepeat = charPosition.get(s.charAt(i))+1;
            }
            charPosition.put(s.charAt(i),i);

        }

        //we do a additional test to control if at the end we have a longer substring, the control is needed
        //because at the end can be no trigger from a repeated char
        if(i-startOfLastRepeat > max)
            max = i-startOfLastRepeat;
        return max;
    }

    public static void main(String[] args) {
        String input = "pwwkew";
        Exercise003 test = new Exercise003();
        int lenghtNoRepeat = test.lengthOfLongestSubstring(input);
        System.out.println(lenghtNoRepeat);
    }
}

