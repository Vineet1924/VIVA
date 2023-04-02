public class Kadanes {
    public static void main(String[] args) {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int currentSum = 0, maximumSum = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            if(maximumSum < currentSum) {
                maximumSum = currentSum;
            }

            if(currentSum < 0) {
                currentSum = 0;
            }
        }

        System.out.println(maximumSum);
    }
}
