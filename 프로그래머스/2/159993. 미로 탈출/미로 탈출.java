import java.util.*;

class Solution {

    static class Node {
        int r, c, cnt;

        Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static int N, M;
    static char[][] map;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();

        map = new char[N][M];

        int sr = 0, sc = 0;
        int lr = 0, lc = 0;
        int er = 0, ec = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = maps[i].charAt(j);

                if (map[i][j] == 'S') {
                    sr = i;
                    sc = j;
                } else if (map[i][j] == 'L') {
                    lr = i;
                    lc = j;
                } else if (map[i][j] == 'E') {
                    er = i;
                    ec = j;
                }
            }
        }

        int startToLever = bfs(sr, sc, lr, lc);
        if (startToLever == -1) return -1;

        int leverToExit = bfs(lr, lc, er, ec);
        if (leverToExit == -1) return -1;

        return startToLever + leverToExit;
    }

    static int bfs(int sr, int sc, int tr, int tc) {
        Queue<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];

        q.add(new Node(sr, sc, 0));
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.r == tr && now.c == tc) {
                return now.cnt;
            }

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (visited[nr][nc]) continue;
                if (map[nr][nc] == 'X') continue;

                visited[nr][nc] = true;
                q.add(new Node(nr, nc, now.cnt + 1));
            }
        }

        return -1;
    }
}