public class Floor {

    public static void main(String[] args) {
        int []arr = {2,3,5,9,14,16,18};

        int index = floor(arr,1);
        System.out.println("value found at the index " + index);
    }



    //return the index of greater number <= target
    //floor = greatest element in the array greater then or equal to target
    /*

    ex   2,3,5,9,14,16,18    target is 15

    index 4  wgich is 14  14<=15
     */
    static int floor(int []arr,int target){

        //1 2 3 4 6 7
        //0 1 2 3 4 5

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
        return end;
    }
}
