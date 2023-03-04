public class OrderAgnosticBS {
    public static void main(String[] args) {
        int[] arr = {-12, -8, -4, 0, 4, 10, 15, 30, 45}; // Asc
        //int[] arr = {76, 45, 34, 23, 12, 9, 5, 2, -2, -25, -44}; //Des
        int target = 4;
        int ans = orderAgnosticBS(arr, target);
        System.out.println(ans);
    }

    static int orderAgnosticBS(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        //find whether the array is sorted in ascending or descending
        boolean isAsc = arr[start] < arr[end];
//        boolean isAsc;
//        if (arr[start] < arr[end]) {
//            isAsc = true;
//        } else {
//            isAsc = false;

            while (start <= end) {

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


