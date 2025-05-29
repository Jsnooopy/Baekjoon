package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int mod = 10007;
        int[][] dp = new int[N + 1][10];

        Arrays.fill(dp[1], 1);

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k] % mod;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[N][i] % mod;
        }

        System.out.println(result % mod);
    }
}
