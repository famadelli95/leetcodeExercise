public class Exercise008StringToInteger {

    /*
    Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
    The algorithm for myAtoi(string s) is as follows:
    Read in and ignore any leading whitespace.
    Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
    Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
    Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
    If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
    Return the integer as the final result.
     */

    public int myAtoi(String s) {

        //boolean to know if the value is positive or negative
        int isPositive = 1;
        // boolean to know if we already have foundSign or if we are already reading the number
        Boolean foundSign = false;
        // the value to return
        long value = 0;

        for(char c : s.toCharArray()){

            // skip the space
            if(c == ' ' && !foundSign);
            // if positive
            else if(c == '+' && !foundSign)
                foundSign = true;
            // if negative
            else if(c == '-' && !foundSign) {
                foundSign = true;
                isPositive = -1;
            }
            // if number
            else if(Character.isDigit(c)){
                value = value * 10 + Character.getNumericValue(c) * isPositive;
                foundSign = true;
            }
            // if it a character it ends the loop
            else break;

            // check if value is maximum
            if (value > Integer.MAX_VALUE) {
                value = Integer.MAX_VALUE;
                break;
            }

            // check if value is minimum
            else if (value < Integer.MIN_VALUE) {
                value = Integer.MIN_VALUE;
                break;
            }
        }

        return (int) value;

    }

    public static void main(String[] args) {
        String v = "   +0 123";
        Exercise008StringToInteger test = new Exercise008StringToInteger();
        int value = test.myAtoi(v);
        System.out.println(value);
    }
}
