public class BinarySearch {
    public static int binarySearch(int arr[], int low, int high, int x) {
        int mid = (low + high) / 2;

        if(x == arr[mid]) {
            return arr[mid];
        } else if(x > arr[mid]) {
            return binarySearch(arr, mid  + 1, high, x);
        } else {
            return binarySearch(arr, low, mid - 1, x);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int high = binarySearch(arr, 0, arr.length, 4); 
        System.out.println(high);
    }
}
