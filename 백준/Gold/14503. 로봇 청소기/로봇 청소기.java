import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] board;
    static int n, m, r, c, d;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(robot());
    }

    public static int robot() {
        int answer = 0;

        while (true) {
            if (board[r][c] == 0) {
                board[r][c] = 2;
                answer++;
            }

            boolean flag = false;

            for (int i = 0; i < 4; i++) {
                if (d == 0) {
                    d = 3;
                } else {
                    d--;
                }

                int nx = r + dx[d];
                int ny = c + dy[d];

                if (board[nx][ny] == 0) {
                    r = nx;
                    c = ny;
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                int nx = 0;
                int ny = 0;

                if (d == 0 || d == 1) {
                    nx = r + dx[d+2];
                    ny = c + dy[d+2];
                } else {
                    nx = r + dx[d-2];
                    ny = c + dy[d-2];
                }

                if (board[nx][ny] == 1) {
                    return answer;
                }

                r = nx;
                c = ny;
            }
        }
    }
}
