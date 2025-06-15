package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S10819 {
    public static int N;
    public static int[] arr, print;
    public static boolean[] visit;
    public static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        print = new int[N];
        visit = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(result);
    }

    public static void dfs(int depth) {
        if (depth == N) {
            result = Math.max(result, get(print));
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

    public static int get(int[] print) {
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += Math.abs(print[i] - print[i + 1]);
        }
        return sum;
    }
}
