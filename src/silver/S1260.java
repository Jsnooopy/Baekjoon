package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1260 {
    static int N, M, V;
    static boolean[] visit1, visit2;
    static ArrayList<Integer>[] edgeList;
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visit1 = new boolean[N + 1];
        visit2 = new boolean[N + 1];
        edgeList = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            edgeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            edgeList[from].add(to);
            edgeList[to].add(from);
        }

        for (int i = 1; i <= N; i++) {
            edgeList[i].sort(Comparator.naturalOrder());
        }

        dfs(V);
        sb.append("\n");

        bfs(V);

        System.out.println(sb);
    }

    static void dfs(int start) {
        if (visit1[start]) {
            return;
        }

        visit1[start] = true;
        sb.append(start).append(" ");
        for (int to : edgeList[start]) {
            if (!visit1[to]) {
                dfs(to);
            }
        }
    }

    static void bfs(int start) {
        queue.offer(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (!visit2[now]) {
                sb.append(now).append(" ");
            }
            visit2[now] = true;

            for (int to : edgeList[now]) {
                if (!visit2[to]) {
                    queue.offer(to);
                }
            }
        }
    }
}
