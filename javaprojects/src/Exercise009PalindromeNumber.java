public class Exercise009PalindromeNumber {

    /*
    Given an integer x, return true if x is palindrome integer.

    An integer is a palindrome when it reads the same backward as forward.
     */

    public boolean isPalindrome(int x) {

        // if negative the sign will make the value no palindrome
        if (x<0)
            return false;

        int indexEnd = 1;
        //find the indexEnd of the integer
        for (int x2 = x ;x2 > 9; indexEnd = indexEnd * 10, x2 = x2/10);

        //compare startIndex with end index to check if palindrome
        for(int x2 = x; indexEnd > 1; indexEnd = indexEnd / 100){

            int smallValue = x2 / indexEnd;
            int greatValue = x2 % 10;

            // compare last greater value with smaller
            if(smallValue != greatValue)
                return false;

            // remove the edges of the value
            x2 = x2 - greatValue * indexEnd;
            x2 = x2 / 10;
        }
        return true;
    }

    public static void main(String[] args) {
        int v = -101;
        Exercise009PalindromeNumber test = new Exercise009PalindromeNumber();
        boolean isPalindrome = test.isPalindrome(v);
        System.out.println(isPalindrome);
    }
}
