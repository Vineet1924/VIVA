public class DPMakingChange {
    public static void main(String[] args) {
        int denomination[] = { 1, 4, 6 };
        int amount = 8;
        int matrix[][] = new int[denomination.length][amount];

        for(int i = 0; i < denomination.length; i++) {
            matrix[i][0] = 0;
        }

        for (int i = 0; i < denomination.length; i++) {
            for (int j = 0; j < amount; j++) {
                if (i == 0) {
                    if (j < denomination[i]) {
                        matrix[i][j] = 1000;
                    } else {
                        matrix[i][j] = 1 + matrix[i][j - denomination[1]];
                    }
                } else {
                    if (j < denomination[i]) {
                        matrix[i][j] = matrix[i - 1][j];
                    } else {
                        matrix[i][j] = 1 + matrix[i][j - denomination[i]];
                    }
                }
            }
        }

        for (int i = 0; i < denomination.length; i++) {
            for (int j = 0; j < amount; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
