package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class G13913 {
    static int N, K;
    static int[] visit, trace;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visit = new int[100001];
        trace = new int[100001];

        bfs(N);
        System.out.println(visit[K]);
        System.out.println(sb);
    }

    static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        while (!q.isEmpty()) {
            int p = q.poll();

            if (p == K) {
                Stack<Integer> s = new Stack<>();
                for (int i = p; i != n; i = trace[i]) {
                    s.push(i);
                }
                s.push(n);

                while (!s.isEmpty()) {
                    sb.append(s.pop()).append(" ");
                }
                break;
            }

            for (int i = 0; i < 3; i++) {
                int np;

                if (i == 0) {
                    np = p - 1;
                } else if (i == 1) {
                    np = p + 1;
                } else {
                    np  = p * 2;
                }

                if (np < 0 || np > 100000 || visit[np] != 0) {
                    continue;
                }

                q.add(np);
                visit[np] = visit[p] + 1;
                trace[np] = p;
            }
        }
    }
}
