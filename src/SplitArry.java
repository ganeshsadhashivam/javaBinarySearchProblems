public class SplitArry {


    //https://leetcode.com/problems/split-array-largest-sum/
    public static void main(String[] args) {
    int []arr = {7,2,5,10,8};
    System.out.println(splitArray(arr,2));
    }

 static int splitArray(int[] nums, int k) {
        int start=0;
        int end = 0;


        for(int i=0;i< nums.length;i++){
            //in the end of the loop this will contain the maximum item from the array
            start = Math.max(start,nums[i]);
            end += nums[i];
        }
        //binary search
        while(start<end){
            //middle as potential ans
            int mid = start+(end-start)/2;

            //calculate hpw many places you can divide this in with this max
            int sum=0;
            int pieces = 1;
            for(int num:nums){
                if(sum + num > mid){
                    //you cannot add this in this subarray make new one
                    //you add this num in new subarray then sum = num
                    sum  = num;
                    pieces++;

                }else{
                    sum +=num;
                }
            }

            if(pieces > k){
                start = mid +1;
            }else{
                end = mid;
            }
        }

        return  end; //start == end;
    }


}
