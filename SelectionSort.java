public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {1, 4, 2, 5, 8};
        int n = arr.length;
        int min = 0;
        int temp = 0;

        for (int i = 0; i < n - 1; i++) {
            min = i;

            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }

            if(min != i) {
                temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }

        for(int i = 0; i < n; i++) {
            System.out.print(" " + arr[i]);
        }
    }
}
