package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G16236 {

    static class Fish implements Comparable<Fish> {
        int x, y, dist;

        Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Fish o) {
            if (this.dist == o.dist) {
                if (this.y == o.y) {
                    return this.x - o.x; 
                }
                return this.y - o.y;
            }
            return this.dist - o.dist; 
        }
    }

    static int N;
    static int[][] space;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int babySize = 2;
    static int eatCount = 0;
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        space = new int[N][N];
        int babyX = 0, babyY = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
                if (space[i][j] == 9) {
                    babyX = j;
                    babyY = i;
                    space[i][j] = 0; 
                }
            }
        }

        while (true) {
            Fish fish = bfs(babyX, babyY);
            if (fish == null) break; 

            babyX = fish.x;
            babyY = fish.y;
            time += fish.dist;

            space[babyY][babyX] = 0;
            eatCount++;
            if (eatCount == babySize) {
                babySize++;
                eatCount = 0;
            }
        }

        System.out.println(time);
    }

    static Fish bfs(int x, int y) {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0});
        visited[y][x] = true;

        PriorityQueue<Fish> candidates = new PriorityQueue<>();

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1], dist = cur[2];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[ny][nx]) continue;
                if (space[ny][nx] > babySize) continue; 

                visited[ny][nx] = true;

                if (space[ny][nx] != 0 && space[ny][nx] < babySize) {
                    candidates.add(new Fish(nx, ny, dist + 1));
                }

                q.add(new int[]{nx, ny, dist + 1});
            }
        }

        if (candidates.isEmpty()) return null;
        return candidates.poll();
    }
}