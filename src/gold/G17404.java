package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G17404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];
        int[][] dp = new int[N][3];
        int[][][] color = new int[N][3][1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            cost[i][0] = r;
            cost[i][1] = g;
            cost[i][2] = b;
        }

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];
        color[0][0][0] = 1;
        color[0][1][0] = 2;
        color[0][2][0] = 3;
        for (int i = 1; i < N; i++) {
            int min1 = Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][0] = cost[i][0] + min1;
            if (min1 == dp[i - 1][1]) color[i][0][0] = color[i - 1][1][0];
            else color[i][0][0] = color[i - 1][2][0];

            int min2 = Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = cost[i][1] + min2;
            if (min2 == dp[i - 1][0]) color[i][1][0] = color[i - 1][0][0];
            else color[i][1][0] = color[i - 1][2][0];

            int min3 = Math.min(dp[i - 1][0], dp[i - 1][1]);
            dp[i][2] = cost[i][2] + min3;
            if (min3 == dp[i - 1][0]) color[i][2][0] = color[i - 1][0][0];
            else color[i][2][0] = color[i - 1][1][0];
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (color[N - 1][i][0] != i + 1) {
                result = Math.min(result, dp[N - 1][i]);
            }
        }

        dp = new int[N][3];
        color = new int[N][3][1];
        dp[N - 1][0] = cost[N - 1][0];
        dp[N - 1][1] = cost[N - 1][1];
        dp[N - 1][2] = cost[N - 1][2];
        color[N - 1][0][0] = 1;
        color[N - 1][1][0] = 2;
        color[N - 1][2][0] = 3;
        for (int i = N - 2; i >= 0; i--) {
            int min1 = Math.min(dp[i + 1][1], dp[i + 1][2]);
            dp[i][0] = cost[i][0] + min1;
            if (min1 == dp[i + 1][1]) color[i][0][0] = color[i + 1][1][0];
            else color[i][0][0] = color[i + 1][2][0];

            int min2 = Math.min(dp[i + 1][0], dp[i + 1][2]);
            dp[i][1] = cost[i][1] + min2;
            if (min2 == dp[i + 1][0]) color[i][1][0] = color[i + 1][0][0];
            else color[i][1][0] = color[i + 1][2][0];

            int min3 = Math.min(dp[i + 1][0], dp[i + 1][1]);
            dp[i][2] = cost[i][2] + min3;
            if (min3 == dp[i + 1][0]) color[i][2][0] = color[i + 1][0][0];
            else color[i][2][0] = color[i + 1][1][0];
        }

        for (int i = 0; i < 3; i++) {
            if (color[0][i][0] != i + 1) {
                result = Math.min(result, dp[0][i]);
            }
        }

        System.out.println(result);
    }
}
