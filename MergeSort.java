public class MergeSort {
    public static void conquer(int arr[], int start, int mid, int end) {
        int merged[] = new int[end - start + 1];
        int x = 0;
        int i = start;
        int j = mid + 1;

        while(i <= mid && j <= end) {
            if(arr[i] <= arr[j]) {
                merged[x++] = arr[i++];
            } else {
                merged[x++] = arr[j++];
            }
        }

        while(i <= mid) {
            merged[x++] = arr[i++];
        }

        while(j <= end) {
            merged[x++] = arr[j++];
        }

        for(int k = 0, l = start; k < merged.length; k++, l++) {
            arr[l] = merged[k];
        }
    }

    public static void devide(int arr[], int start, int end) {
        if(start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        devide(arr, start, mid);
        devide(arr, mid + 1, end);
        conquer(arr, start, mid, end);
    }
    public static void main(String[] args) {
        int arr[] = {5, 4, 3, 2, 1};

        devide(arr, 0, arr.length - 1);

        for(int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }
}
