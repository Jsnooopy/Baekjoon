import java.io.*;
import java.util.*;

class Solution {

    static int N;
    static int[][] board;
    static int[][][] dist;
    static int[] dx = {0, 0, 0, -1, 1}, dy = {0, -1, 1, 0, 0};

    public int solution(int[][] board) {
        N = board.length;
        this.board = board;

        dist = new int[N][N][5];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }

        bfs(0, 0);

        int answer = Integer.MAX_VALUE;
        for (int dir = 1; dir <= 4; dir++) {
            answer = Math.min(answer, dist[N - 1][N - 1][dir]);
        }

        return answer;
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{x, y, 0});
        dist[y][x][0] = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int now_x = now[0];
            int now_y = now[1];
            int now_dir = now[2];

            for (int i = 1; i <= 4; i++) {
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];

                if (next_x < 0 || next_y < 0 || next_x >= N || next_y >= N) continue;
                if (board[next_y][next_x] == 1) continue;

                int nextCost;

                if (now_dir == 0) {
                    nextCost = dist[now_y][now_x][now_dir] + 100;
                } else if ((now_dir <= 2 && i <= 2) || (now_dir >= 3 && i >= 3)) {
                    nextCost = dist[now_y][now_x][now_dir] + 100;
                } else {
                    nextCost = dist[now_y][now_x][now_dir] + 600;
                }

                if (dist[next_y][next_x][i] > nextCost) {
                    dist[next_y][next_x][i] = nextCost;
                    q.offer(new int[]{next_x, next_y, i});
                }
            }
        }
    }
}