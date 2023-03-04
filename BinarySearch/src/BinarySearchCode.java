public class BinarySearchCode {
    public static void main(String[] args) {
        int[] arr = {-12, -8, -4, 0, 4, 10, 15, 30, 45};
        int target = 67;
        int ans = binarySearch(arr, target);
        System.out.println(ans);
    }

    //return the index
    //return -1 if it does not exist
    static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        //find the middle element
        //int mid = (start + end) / 2; //might e possible that (start + end) exceeds the range of int in java......
        while(start <= end){

            int mid = start + (end - start) / 2;

            if(target < arr[mid]){
                end = mid - 1;
            }
            else if(target > arr[mid]){
                start = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}
