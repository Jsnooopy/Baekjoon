package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S15988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int mod = 1000000009;

        long[] dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < 1000001; i++) {
            dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % mod;
        }

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());

            sb.append(dp[num]).append("\n");
        }
        System.out.println(sb);
    }
}
