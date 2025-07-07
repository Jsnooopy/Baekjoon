package gold;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G7576 {
    static int M, N, day, cnt;
    static int[][] Tomato;
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    static Queue<Point> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        Tomato = new int[N][M];
        q = new LinkedList<>();
        day = -1;
        cnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Tomato[i][j] = Integer.parseInt(st.nextToken());

                if (Tomato[i][j] == 1) {
                    q.add(new Point(j, i));
                } else if (Tomato[i][j] == 0) {
                    cnt++;
                }
            }
        }

        if (cnt == 0) {
            System.out.println(0);
        } else {
            bfs();
            System.out.println(cnt != 0 ? "-1" : day);
        }
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int dayCycle = q.size();

            for (int cycle = 0; cycle < dayCycle; cycle++) {
                Point p = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= M || ny >= N || Tomato[ny][nx] == 1 || Tomato[ny][nx] == -1) {
                        continue;
                    }

                    Tomato[ny][nx] = 1;
                    cnt--;
                    q.add(new Point(nx, ny));
                }
            }
            day++;
        }
    }
}
