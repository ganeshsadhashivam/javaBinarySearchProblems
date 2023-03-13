public class RotationCount {
    public static void main(String[] args) {
        int [] arr = {4,5,6,7,0,1,2};
      //  int [] arr = {1,2,3,4,5,6,7};
        System.out.println(countRotations(arr));
    }

    private static int countRotations(int [] arr){
        int pivot = findPivot(arr);
        return pivot + 1;
    }

    //use for non duplicates
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

    //use for duplicates
    static int findPivotWithDupicates(int []arr){
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
            //if elements at middle, start,end are equal then just skip the deuplicates
            if (arr[mid] <= arr[start] && arr[mid] == arr[end]) {
                //skip the duplicates
                //Note What if the elements at start and end were the pivot
                //check if start is pivot
                if(arr[mid] > arr[mid+1] ){
                    return start;
                }
                start++;
                //check whether end is pivot
                if(arr[end] <arr[end-1]){
                    return end-1;
                }
                end--;
            }
            //left side is sorted so pivot should be in right
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])){
                start = mid+1;
            }
            else{
                end = mid - 1;
            }

        }

        return -1;
    }
}
