public interface Ceiling {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        int target = 20;
        int ans = ceiling(arr, target);
        System.out.println(ans);
    }

    //return the index: smallest number >= target
    static int ceiling(int[] arr, int target) {
        //but when if the target is greater than the greatest number in the array
        if(target > arr[arr.length-1]){
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        //find the middle element
        //int mid = (start + end) / 2; //might e possible that (start + end) exceeds the range of int in java......
        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return start;
    }
}

