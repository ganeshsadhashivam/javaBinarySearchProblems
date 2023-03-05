public class SmallestLetter {
    public static void main(String[] args) {
        //https://leetcode.com/problems/find-smallest-letter-greater-than-target/
       char []arr = {'c','f','j'};

       char index = greatestCharacter(arr,'j');
        System.out.println("value found at the index " + index);
    }


    //return the index of smallest No >= target
    //ceiling = smallest element in the array greater then or equal to target
    /*

    ex    {2,3,5,9,14,16,18};   target is 15

    smalleste No  16,18 >=15  i.e is 16 which is smallest between 16,18
     */
    static char greatestCharacter(char[]arr,char target){

        int  start=0;
        int  end=arr.length-1;

        while(start <= end){
            //find the element mid point
            int  mid = start +(end-start)/2;
            System.out.println(target + " <" + arr[mid]);
            if(target < arr[mid]){
                end = mid-1;
            }
            else {
                start = mid+1;
            }

        }
        return arr[start % arr.length];

    }
}
