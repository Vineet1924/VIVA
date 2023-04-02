public class MakingChangeGreedy {
    public static void main(String[] args) {
        int denominations[] = {200, 100, 50, 20, 10, 5};
        int changeAmount = 365;
        int ans = 0;

        for(int i = 0; i < denominations.length && changeAmount >= 0;) {
            if(changeAmount - denominations[i] >= 0) {
                changeAmount -= denominations[i];
                ans += 1;
            } else {
                i++;
            }
        }

        if(changeAmount == 0) {
            System.out.println(ans);
        } else {
            System.out.println("Solution not possible");
        }
    }
}
