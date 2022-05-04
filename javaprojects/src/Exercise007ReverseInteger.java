public class Exercise007ReverseInteger {
    /*
    Given a signed 32-bit integer x, return x with its digits reversed.
    If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
     */
    public int reverse(int x) {
        int reversed = 0;
        while (x != 0){
            // check if the result is between the max and min bounds
            if (reversed > Integer.MAX_VALUE/10 || reversed < Integer.MIN_VALUE/10)
                return 0;

            // add the current digit in the result
            reversed = reversed * 10 + x % 10;
            x = x/10;
        }
        return reversed;
    }

    public static void main(String[] args) {
        int v = 1463847412;
        Exercise007ReverseInteger test = new Exercise007ReverseInteger();
        int reversed = test.reverse(v);
        System.out.println(reversed);
    }
}
