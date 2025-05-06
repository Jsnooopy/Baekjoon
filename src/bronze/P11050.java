package bronze;

import java.util.Scanner;

public class P11050 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        long result = factorial(n) / (factorial(k) * factorial(n - k));

        System.out.println(result);
    }

    private static long factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

}