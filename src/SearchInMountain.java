public class SearchInMountain {
    public static void main(String[] args) {
       // https://leetcode.com/problems/find-in-mountain-array/

    int []array = {1,2,3,4,5,3,1};
    System.out.println(search(array,3));


    }
  static int search(int []arr,int target) {

        int peak = peakIndexInMountainArray(arr);
        int firstTry = orderAgnosticBinarySearch(arr,target,0,peak);
        if(firstTry != -1){

            return firstTry;

        }
        //Try to search in second half
        return orderAgnosticBinarySearch(arr,target,peak+1,arr.length-1);
    }


  static int peakIndexInMountainArray(int[] arr) {

        int start = 0;
        int end = arr.length-1;

        while(start < end){

            int mid = start +(end-start)/2;

            //if this is true
            if(arr[mid] > arr[mid+1]){
                //you are in the decreasing part of the array
                //this may be the answer but look at left
                //this is why end != mid -1

                end = mid;
            }else{
                //you are in the asc part of array
                start = mid + 1; //because w eknow that mid+1 element > mid element
            }
            //in the end start == end and pointing to the largest no because of the 2 checks above
            //start and end are always trying to find max element in the above 2 checks
            //hence when they are pointing to just one element that is the max element because that is what check say
            //more elaboration at every point of time for start and end they have the  best possible answer till that time
            //and if we are saying if only ine item is remaining ,hence bacause of  above line that is the best possible answer

        }

        return start;
    }

    static int orderAgnosticBinarySearch(int []arr,int target,int start,int end){

        //1 2 3 4 5 6 7
        //0 1 2 3 4 5 6

//       int  start=0;
//       int  end=arr.length-1;
//
//       //
//
//        while(start <= end){
//            //find the element mid point
//           int  mid = start +(end-start)/2;
//
//           if(target < arr[mid]){
//               end = mid-1;
//           }
//           else if(target > arr[mid]){
//               start = mid+1;
//           }
//           else{
//               //ans found
//               return mid;
//           }
//        }
//        return -1;
        // find whether the array is sorted in ascending or descending
        boolean isAsc = arr[start] < arr[end];

        while(start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
