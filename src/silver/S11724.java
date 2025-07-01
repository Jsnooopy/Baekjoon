package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S11724 {
    static boolean[] visit;
    static ArrayList<Integer>[] edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visit = new boolean[N + 1];
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

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                cnt++;
                dfs(i);
            }
        }

        System.out.println(cnt);
    }

    static void dfs(int start) {
        visit[start] = true;
        for (int val : edgeList[start]) {
            if (!visit[val]) {
                dfs(val);
            }
        }
    }
}
