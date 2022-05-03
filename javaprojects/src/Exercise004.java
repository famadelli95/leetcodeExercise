public class Exercise004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lengthArrays = nums1.length + nums2.length;
        int indexNum1 =0, indexNum2 =0, indexArrays =0;
        double median;
        int numberBefore = 0;

        // find the median index
        for(; indexArrays<lengthArrays/2 ; indexArrays++){
            if(indexNum1 >= nums1.length) {
                numberBefore = nums2[indexNum2];
                indexNum2++;
            }
            else if(indexNum2 >= nums2.length) {
                numberBefore = nums1[indexNum1];
                indexNum1++;
            }
            else if(nums1[indexNum1]<nums2[indexNum2]){
                // save the number before in case of even concat array
                numberBefore = nums1[indexNum1];
                indexNum1++;
            }
            else{
                // save the number before in case of even concat array
                numberBefore = nums2[indexNum2];
                indexNum2++;
            }
        }

        int minNumber;
        if(indexNum1 >= nums1.length)
            minNumber = nums2[indexNum2];
        else if(indexNum2 >= nums2.length)
            minNumber = nums1[indexNum1];
        else
            minNumber = Math.min(nums1[indexNum1], nums2[indexNum2]);

        // if odd
        if(lengthArrays % 2 == 1){
            median = minNumber;
        }

        // if even
        else {
            median = (minNumber+numberBefore)/2.0;
        }

        return median;
    }

    public static void main(String[] args) {
        int[] num1 = {1,2};
        int[] num2 = {3,4};
        Exercise004 test = new Exercise004();
        double meridian = test.findMedianSortedArrays(num1,num2);
        System.out.println(meridian);
    }
}
