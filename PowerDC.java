public class PowerDC {
    public static int power(int a, int n) {
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            return a;
        }
        if(n % 2 == 0) {
            int t = power(a, n/2);
            return (t * t);
        } else {
            int t = power(a, n - 1 / 2);
            return (t * t * a);
        }
    }

    public static void main(String[] args) {
        int ans = power(4,4);
        System.out.println(ans);
    }  
}
