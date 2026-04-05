import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] board;
    static int[][][] distance;
    static int[] dy = {0, 0, 0, 1, -1};
    static int[] dx = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int sy = Integer.parseInt(st.nextToken());
        int sx = Integer.parseInt(st.nextToken());
        int sd = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int ey = Integer.parseInt(st.nextToken());
        int ex = Integer.parseInt(st.nextToken());
        int ed = Integer.parseInt(st.nextToken());

        distance = new int[N + 1][M + 1][5];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                Arrays.fill(distance[i][j], -1);
            }
        }

        bfs(sy, sx, sd);
        System.out.println(distance[ey][ex][ed]);
    }

    static void bfs(int sy, int sx, int sd) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sy, sx, sd});
        distance[sy][sx][sd] = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];
            int dir = now[2];

            int left = turnLeft(dir);
            int right = turnRight(dir);

            if (distance[y][x][left] == -1) {
                distance[y][x][left] = distance[y][x][dir] + 1;
                q.offer(new int[]{y, x, left});
            }

            if (distance[y][x][right] == -1) {
                distance[y][x][right] = distance[y][x][dir] + 1;
                q.offer(new int[]{y, x, right});
            }

            for (int k = 1; k <= 3; k++) {
                int ny = y + dy[dir] * k;
                int nx = x + dx[dir] * k;

                if (ny < 1 || nx < 1 || ny > N || nx > M) break;
                if (board[ny][nx] == 1) break;
                if (distance[ny][nx][dir] != -1) continue;

                distance[ny][nx][dir] = distance[y][x][dir] + 1;
                q.offer(new int[]{ny, nx, dir});
            }
        }
    }

    static int turnLeft(int dir) {
        if (dir == 1) return 4;
        if (dir == 2) return 3;
        if (dir == 3) return 1;
        return 2;
    }

    static int turnRight(int dir) {
        if (dir == 1) return 3;
        if (dir == 2) return 4;
        if (dir == 3) return 2;
        return 1;
    }
}
