//https://leetcode.com/problems/peak-index-in-a-mountain-array/

public class MountainArray {
    public static void main(String[] args) {

    }
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(arr[mid] > arr[mid + 1]) {
                // you are in dec part of array
                //this may be the ans, but look at left
                // this is why end != mid -1
                end = mid;
            }
            else{
                // you are in asc part of array
                start = mid + 1; // because we know that mid+1 element > mid element, hence we are ignoring middle element
            }
        }
        // in the end, start == end and pointing to the largest number because of the two checks above .....
        //start and end are always trying to find max element in the above 2 checks
        //hence, when they are pointing to just one element, that is the maximum one because that is what the checks says .....
        // more elaboration: at every point of time for start and end, they have the best possible answer till that time
        //and if we are saying that only one item is remaining, hence because of above line that is the possible answer
        return start; //or return end as both are equal

    }
}
