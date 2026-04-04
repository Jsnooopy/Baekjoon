import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, Y;
    static boolean divide, end;
    static int[][] iceberg;
    static int[][] melt;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        iceberg = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                iceberg[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (!divide && !end) {
            year();
        }

        if (!end) {
            System.out.println(Y);
        } else {
            System.out.println(0);
        }

    }

    static void year() {
        melt = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (iceberg[i][j] != 0) {
                    int cnt = 0;

                    for (int k = 0; k < 4; k++) {
                        int nx = j + dx[k];
                        int ny = i + dy[k];

                        if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;

                        if(iceberg[ny][nx] == 0) cnt++;
                    }

                    melt[i][j] = cnt;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (iceberg[i][j] != 0) {
                    iceberg[i][j] -= melt[i][j];
                    if(iceberg[i][j] < 0) iceberg[i][j] = 0;
                }
            }
        }
        Y++;
        check();
    }

    static void check() {
        int piece = 0;
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (iceberg[i][j] != 0 && !visited[i][j]) {
                    bfs(j, i);
                    piece++;
                }
            }
        }
        if(piece > 1) divide = true;
        if(piece == 0) end = true;
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if (visited[ny][nx]) continue;

                if (iceberg[ny][nx] != 0) {
                    q.add(new int[]{nx, ny});
                    visited[ny][nx] = true;
                }
            }
        }
    }

}
