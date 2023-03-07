import java.util.Arrays;

public class FirstAndLastPostion {

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        int [] val = searchRange(arr, 7);

            System.out.println(Arrays.toString(val));
    }


static int[] searchRange(int[] nums, int target) {

        int[] ansarr = {-1, -1};

        ansarr[0] = search(nums, target, true);
        System.out.println(ansarr[0]);
        if(ansarr[0] != -1){
            ansarr[1] = search(nums, target, false);
        }

        System.out.println(ansarr[1]);
        //check for first occurence
    return ansarr;
    }

    //this function returns index value of target
 static int search(int[] nums, int target, boolean findStartIndex) {

     int ans = -1;
        int start = 0;
        int end = nums.length - 1;


        //check for first occurence
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                ans = mid;
                if(findStartIndex){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }

            }

        }
        return ans;

   }

}