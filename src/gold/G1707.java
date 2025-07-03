package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G1707 {
    static int K, V, E;
    static int[] colors;
    static ArrayList<Integer>[] edgeList;
    static final int RED = 1;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < K; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            colors = new int[V + 1];
            edgeList = new ArrayList[V + 1];

            for (int i = 1; i <= V; i++) {
                edgeList[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                edgeList[from].add(to);
                edgeList[to].add(from);
            }

            boolean rst = false;

            for (int i = 1; i <= V; i++) {
                if (colors[i] == 0) {
                    rst = isBi(i, RED);
                }
                if (!rst) {
                    break;
                }
            }

            if (rst) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean isBi(int start, int color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        colors[start] = color;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : edgeList[now]) {
                if (colors[now] == colors[next]) {
                    return false;
                }

                if (colors[next] == 0) {
                    colors[next] = colors[now] * -1;
                    queue.offer(next);
                }
            }
        }
        return true;
    }
}
