package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1];

        for (int i = 2; i <= n; i++) {
            if (i == 2) {
                dp[i] = dp[i - 1] + arr[i];
                continue;
            }
            if (i == 3) {
                dp[i] = Math.max(arr[i - 1] + arr[i], Math.max(dp[i - 1], dp[i - 2] + arr[i]));
                continue;
            }
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
        }
        System.out.println(dp[n]);
    }
}
