package silver;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S7562 {
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1}, dy = {2, 1, -1, -2, -2, -1, 1, 2};
    static int I, finishX, finishY, startX, startY;
    static boolean[][] visit;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            I = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            finishX = Integer.parseInt(st.nextToken());
            finishY = Integer.parseInt(st.nextToken());

            visit = new boolean[I][I];
            arr = new int[I][I];
            bfs(startX, startY);

            sb.append(arr[finishY][finishX]).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visit[y][x] = true;
        arr[y][x] = 0;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.x == finishX && p.y == finishY) {
                break;
            }
            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= I || ny >= I || visit[ny][nx]) {
                    continue;
                }
                visit[ny][nx] = true;
                arr[ny][nx] = arr[p.y][p.x] + 1;
                queue.add(new Point(nx, ny));
            }
        }
    }
}
