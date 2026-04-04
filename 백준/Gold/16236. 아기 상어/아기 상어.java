import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, sx, sy, second, cnt;
    static int size = 2;
    static boolean end;
    static int[][] map;
    static int[] dx = {0, -1, 1, 0}, dy = {-1, 0, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sx = j;
                    sy = i;
                    map[i][j] = 0;
                }
            }
        }

        while (!end) {
            if (!eat()) end = true;
        }

        System.out.println(second);
    }

    static boolean eat() {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy, 0});
        visited[sy][sx] = true;

        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        int distance = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];

            if (dist > distance) break;

            if (map[cy][cx] > 0 && map[cy][cx] < size) {
                if (dist < distance) {
                    distance = dist;
                    x = cx;
                    y = cy;
                } else if (dist == distance) {
                    if (cy < y || (cy == y && cx < x)) {
                        x = cx;
                        y = cy;
                    }
                }
            }

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] > size) continue;

                visited[ny][nx] = true;
                q.add(new int[]{nx, ny, dist + 1});
            }
        }

        if (x == Integer.MAX_VALUE) return false;

        cnt++;
        if (cnt == size) {
            size++;
            cnt = 0;
        }

        second += distance;
        map[y][x] = 0;
        sx = x;
        sy = y;

        return true;
    }
}