public class Main {
    public static void main(String[] args) {

        //https://leetcode.com/problems/find-smallest-letter-greater-than-target/
        int []arr = {2,3,5,9,14,16,18};

        int index = ceiling(arr,55);
        System.out.println("value found at the index " + index);
    }


    //return the index of smallest No >= target
    //ceiling = smallest element in the array greater then or equal to target
    /*

    ex    {2,3,5,9,14,16,18};   target is 15

    smalleste No  16,18 >=15  i.e is 16 which is smallest between 16,18
     */
    static int ceiling(int []arr,int target){

        //1 2 3 4 6 7
        //0 1 2 3 4 5


        //but what if the target is greater than the greatest number in the array
        //in our case if give input as 25 which is greater then greatest
        //element in the array 18
        if(target > arr[arr.length-1]){
            return -1;
        }

        int  start=0;
        int  end=arr.length-1;

        while(start <= end){
            //find the element mid point
            int  mid = start +(end-start)/2;
                    System.out.println(target + " <" + arr[mid]);
            if(target < arr[mid]){
                end = mid-1;
            }
            else if(target > arr[mid]){
                start = mid+1;
            }
            else{
                //ans found
                return mid;
            }
        }
        return start;
    }
//    static int binarySearch(int []arr,int target){
//
//        //1 2 3 4 5 6 7
//        //0 1 2 3 4 5 6
//
//       int  start=0;
//       int  end=arr.length-1;
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
//    }
}