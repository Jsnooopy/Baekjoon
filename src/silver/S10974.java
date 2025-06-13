package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S10974 {
    public static int N;
    public static int[] arr, print;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        print = new int[N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (depth == N) {
            for (int val : print) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                print[depth] = arr[i];
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}
