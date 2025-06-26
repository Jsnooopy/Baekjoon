package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S10971 {
    public static int N;
    public static int[][] W;
    public static int[] arr;
    public static boolean[] visited;
    public static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        visited = new boolean[N];
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(minCost);

    }

    public static void dfs(int depth) {
        if (N == depth) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                int a = arr[i] - 1;
                int b;

                if (i == arr.length-1) b = arr[0] - 1;
                else b = arr[i + 1] - 1;

                if (W[a][b] == 0) return;
                else sum += W[a][b];
            }
            minCost = Math.min(minCost, sum);
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
