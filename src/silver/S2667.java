package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class S2667 {
    static boolean[][] visit;
    static int cnt, N;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                if (s.charAt(j) == '1') {
                    visit[i][j] = true;
                }
            }
        }

        int total = 0;
        ArrayList<Integer> cntarr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j]) {
                    cnt = 0;
                    dfs(i, j);
                    cntarr.add(cnt);
                    total++;
                }
            }
        }
        sb.append(total).append("\n");

        Collections.sort(cntarr);
        for (int val : cntarr) {
            sb.append(val).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int y, int x) {
        visit[y][x] = false;
        cnt++;

        for (int i = 0; i < 4; i++) {
            int yy = y + dy[i];
            int xx = x + dx[i];
            if (yy >= N || yy < 0 || xx >= N || xx < 0 || !visit[yy][xx]) {
                continue;
            }
            dfs(yy, xx);
        }
    }
}
