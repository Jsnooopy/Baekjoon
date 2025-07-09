package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G1261 {
    static int M, N;
    static int[][] room, cnt;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        room = new int[N][M];
        visit = new boolean[N][M];
        cnt = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        bfs(0, 0);
        System.out.println(cnt[N-1][M-1]);
    }

    static void bfs(int x, int y) {
        Queue<spot> q = new LinkedList<>();
        q.add(new spot(x, y));
        visit[y][x] = true;

        while (!q.isEmpty()) {
            spot p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                    continue;
                }

                if (!visit[ny][nx]) {
                    if (room[ny][nx] == 1) {
                        cnt[ny][nx] = cnt[p.y][p.x] + 1;
                    } else {
                        cnt[ny][nx] = cnt[p.y][p.x];
                    }
                    q.add(new spot(nx, ny));
                    visit[ny][nx] = true;
                } else {
                    if (room[ny][nx] == 1) {
                        if (cnt[ny][nx] > cnt[p.y][p.x] + 1) {
                            cnt[ny][nx] = cnt[p.y][p.x] + 1;
                            q.add(new spot(nx, ny));
                        }
                    } else {
                        if (cnt[ny][nx] > cnt[p.y][p.x]) {
                            cnt[ny][nx] = cnt[p.y][p.x];
                            q.add(new spot(nx, ny));
                        }
                    }
                }
            }
        }
    }

    static class spot {
        int x;
        int y;

        public spot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
