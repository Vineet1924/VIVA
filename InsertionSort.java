public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {5, 4, 3, 2, 1};
        int n = arr.length;
        int temp = 0;

        for(int i = 0; i < n - 1; i++) {
            int  j = i + 1;

            while(j > 0 && arr[j - 1] > arr[j]) {
                temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }

        for(int i = 0; i < n; i++) {
            System.out.print(" " + arr[i]);
        }
    }
}
