package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G13023 {
    static int N, M;
    static int answer = 0;
    static boolean[] visit;
    static ArrayList<Integer>[] edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        edgeList = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            edgeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edgeList[from].add(to);
            edgeList[to].add(from);
        }

        for (int i = 0; i < N; i++) {
            if (answer != 1) {
                dfs(i, 1);
            }
        }

        System.out.println(answer);
    }

    static void dfs(int start, int depth) {
        if (depth == 5) {
            answer = 1;
            return;
        }

        visit[start] = true;
        for (int val : edgeList[start]) {
            if (!visit[val]) {
                dfs(val, depth + 1);
            }
        }
        visit[start] = false;
    }
}
