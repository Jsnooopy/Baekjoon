package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1697 {
    static int N, K;
    static int[] dp = {-1, 1};
    static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visit = new int[100001];
        bfs(N);

        System.out.println(visit[K]);
    }

    static void bfs(int a) {
        Queue<Integer> q = new LinkedList<>();
        q.add(a);

        while (!q.isEmpty()) {
            int p = q.poll();

            if (p == K) {
                break;
            }

            for (int i = 0; i < 3; i++) {
                int np;

                if (i < 2) {
                    np = p + dp[i];
                } else {
                    np = p * 2;
                }

                if (np < 0 || np > 100000 || visit[np] != 0) {
                    continue;
                }

                visit[np] = visit[p] + 1;
                q.add(np);
            }
        }
    }
}
