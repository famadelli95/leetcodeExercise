public class Exercise006ZigzagConversion {

    public String convert(String s, int numRows) {
        String result = "";
        if(numRows == 1)
            return s;
        for (int index = 0; index < numRows; index++){
            if(index == 0 || index == numRows-1){
                for(int e=index; e < s.length(); e=e+2*numRows-2){
                    result = result + s.charAt(e);
                }
            }
            else {
                for(int e=index; e < s.length(); e=e+2*numRows-2){
                    result = result + s.charAt(e);
                    if(e+2*(numRows-index)-2<s.length())
                        result = result + s.charAt(e+2*(numRows-index)-2);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "A";
        Exercise006ZigzagConversion test = new Exercise006ZigzagConversion();
        String palindromic = test.convert(s,1);
        System.out.println(palindromic);
    }
}
