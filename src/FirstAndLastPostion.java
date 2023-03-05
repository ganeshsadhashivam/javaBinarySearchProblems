import java.util.Arrays;

public class FirstAndLastPostion {
    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        int [] val = searchRange(arr, 7);

            System.out.println(Arrays.toString(val));


    }



static int[] searchRange(int[] arr, int target) {

        int[] ans = {-1, -1};




        ans[0] = search(arr, target, true);
      System.out.println(ans[0]);
        ans[1] = search(arr, target, false);
    System.out.println(ans[1]);
        //check for first occurence
    return ans;
    }



    //this function returns index value of target
 static int search(int[] nums, int target, boolean findStartIndex) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

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
                    end = mid-1;
                }
                else{
                    end =mid +1;
                }

            }

        }
        return ans;
    }

}