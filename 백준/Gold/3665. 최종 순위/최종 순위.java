import java.io.*;
import java.util.*;

public class Main {

    static int T, N, M;
    static int[] indegree, rank;
    static boolean[][] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            rank = new int[N];
            indegree = new int[N + 1];
            graph = new boolean[N + 1][N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                rank[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    graph[rank[i]][rank[j]] = true;
                    indegree[rank[j]]++;
                }
            }

            M = Integer.parseInt(br.readLine());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (graph[a][b]) {
                    graph[a][b] = false;
                    graph[b][a] = true;
                    indegree[b]--;
                    indegree[a]++;
                } else {
                    graph[b][a] = false;
                    graph[a][b] = true;
                    indegree[a]--;
                    indegree[b]++;
                }
            }

            sb.append(topologySort()).append("\n");
        }

        System.out.print(sb);
    }

    static String topologySort() {
        Queue<Integer> q = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        boolean uncertain = false;

        for (int i = 0; i < N; i++) {
            if (q.isEmpty()) return "IMPOSSIBLE";
            if (q.size() > 1) uncertain = true;

            int now = q.poll();
            result.append(now).append(" ");

            for (int next = 1; next <= N; next++) {
                if (!graph[now][next]) continue;

                indegree[next]--;
                if (indegree[next] == 0) q.offer(next);
            }
        }

        if (uncertain) return "?";
        return result.toString().trim();
    }
}
