package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G12869 {

    static int[][][] dp = new int[61][61][61];
    static int[] attack = {9, 3, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] hp = new int[3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            hp[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 61; i++) {
            for (int j = 0; j < 61; j++) {
                for (int k = 0; k < 61; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        System.out.println(dfs(hp[0], hp[1], hp[2]));
    }

    static int dfs(int a, int b, int c) {
        if(a <= 0 && b <= 0 && c <= 0) return 0;

        a = Math.max(a, 0);
        b = Math.max(b, 0);
        c = Math.max(c, 0);

        if(dp[a][b][c] != -1) return dp[a][b][c];

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i == j) continue;

                for (int k = 0; k < 3; k++) {
                    if(i == k || j == k) continue;

                    int result = dfs(a - attack[i], b - attack[j], c - attack[k]);
                    min = Math.min(min, result);
                }
            }
        }

        return dp[a][b][c] = min + 1;
    }
}
