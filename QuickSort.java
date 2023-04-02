public class QuickSort {
    public int Partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        int temp = 0;

        while(i < j) {
            while(arr[i] <= pivot) {
                i++;
            }

            while(arr[j] > pivot) {
                j--;
            }

            if(i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        temp = arr[j];
        arr[j] = arr[low];
        arr[low] = temp;

        return j;
    }

    public void quicksort(int[] arr, int low, int high) {
        if(low < high) {
            int pivot = Partition(arr, low, high);
            quicksort(arr, low, pivot - 1);
            quicksort(arr, pivot + 1, high);
        }
    }
    
    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ,9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        new QuickSort().quicksort(arr, 0, arr.length - 1);

        for(int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }
}
