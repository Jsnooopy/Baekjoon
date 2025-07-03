package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4963 {
    static boolean[][] visit;
    static int w, h;
    static int[] dx = {1, 1, 1, 0, -1, -1, -1, 0};
    static int[] dy = {1, 0, -1, -1, -1, 0, 1, 1};
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            visit = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    if (Integer.parseInt(st.nextToken()) == 1) {
                        visit[i][j] = true;
                    }
                }
            }

            int total = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (visit[i][j]) {
                        dfs(i, j);
                        total++;
                    }
                }
            }
            sb.append(total).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int y, int x) {
        visit[y][x] = false;

        for (int i = 0; i < 8; i++) {
            int yy = y + dy[i];
            int xx = x + dx[i];

            if (yy >= h || yy < 0 || xx >= w || xx < 0 || !visit[yy][xx]) {
                continue;
            }
            dfs(yy, xx);
        }
    }
}
