public class RotatedSortedArray {
    public static void main(String[] args) {
int[] arr={1};
System.out.println(findPivot(arr));
    }

static int search (int[] nums,int target){
     int pivot=   findPivot(nums);

     //if you didn't found it means the array is not rotated
     if(pivot == -1){
         //just do binary search
    return binarySearch(nums,target,0,nums.length-1);
     }

     //if pivot is found you have
    //case1
    if(nums[pivot] == target){
        return pivot;
    }

    //case2
    if(target > nums[0]){
        return binarySearch(nums,target,0,pivot-1);
    }

    return binarySearch(nums,target,pivot+1, nums.length-1);
}

static int binarySearch(int []arr,int target,int start,int end){

        while(start<=end){
            int mid= start+(end-start)/2;


            if(target < arr[mid]){
                end = mid-1;

            }
            if(target > arr[mid]){
                start = mid+1;

            }
            else{
                //ans found
                return mid;
            }
        }
    return start;

}


    static int findPivot(int []arr){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;

            //case 1:
            if( mid < end && arr[mid] > arr[mid+1] ){
                return mid;
            }

            //case 2:
            if(mid > start && arr[mid] < arr[mid-1] ){
                return mid-1;
            }

            //case 3:
            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
