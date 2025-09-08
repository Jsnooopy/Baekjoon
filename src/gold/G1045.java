package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G1045 {
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] edges = new char[N][N];
        for (int i = 0; i < N; i++) {
            edges[i] = br.readLine().toCharArray();
        }

        // 우선순위 기준으로 (i < j) 간선 나열
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (edges[i][j] == 'Y') {
                    q.add(new int[] {i, j});
                }
            }
        }

        // 도로 개수가 M보다 적으면 불가능
        if (q.size() < M) {
            System.out.println(-1);
            return;
        }

        // Union-Find 초기화
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        Queue<int[]> rest = new LinkedList<>();
        int count = 0;
        int[] result = new int[N];  // 도시별 도로 개수 카운트

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int a = now[0], b = now[1];
            int pa = find(a), pb = find(b);

            if (pa != pb) {
                union(pa, pb);
                result[a]++;
                result[b]++;
                count++;
            } else {
                rest.add(now);
            }
        }

        // MST가 완성되지 않거나 (필요한 연결 수 부족), M개 이하라면 실패
        if (count != N - 1) {
            System.out.println(-1);
            return;
        }

        // 추가 간선으로 M개 채우기
        while (count < M && !rest.isEmpty()) {
            int[] now = rest.poll();
            result[now[0]]++;
            result[now[1]]++;
            count++;
        }

        if (count != M) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int x : result) sb.append(x).append(' ');
            System.out.println(sb.toString().trim());
        }
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        parent[b] = a;
    }
}