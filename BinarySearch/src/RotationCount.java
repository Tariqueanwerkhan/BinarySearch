//https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/

public class RotationCount {
    public static void main(String[] args) {
        int[] arr = {15, 18, 2, 3, 6, 12};
        System.out.println(countRotations(arr));
    }

    private static int countRotations(int[] arr) {
        int pivot = findPivot(arr);
        return pivot + 1;
    }

    //use this for non duplicates......
    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            // 4 cases over here
            //case 1
            if(mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }
            //case 2
            if(mid > start && arr[mid] < arr[mid - 1]){
                return mid - 1;
            }
            //case 3
            if(arr[mid] <= arr[start]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return -1;
    }

    //use this when array contains duplicates .......
    static int findPivotWithDuplicate(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            // 4 cases over here
            //case 1
            if(mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }
            //case 2
            if(mid > start && arr[mid] < arr[mid - 1]){
                return mid - 1;
            }
            // if element at middle, start, end are equal then just skip the duplicates....
            if(arr[mid] == arr[start] && arr[mid] == arr[end]){
                //skip the duplicates
                //NOTE:- what if these elements at start and end were the pivot ??
                //check if start is pivot
                if(arr[start] > arr[start + 1]){
                    return start;
                }
                start++;

                //check whether end is pivot or not .....
                if(arr[end] < arr[end - 1]){
                    return end - 1;
                }
                end--;
            }
            //left side is sorted, so pivot should be in right
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }
}
