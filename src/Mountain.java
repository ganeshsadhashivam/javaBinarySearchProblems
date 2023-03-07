public class Mountain {
    public static void main(String[] args) {

        int [] arr = {0,10,5,2};
        System.out.println(peakIndexInMountainArray(arr));
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
}
