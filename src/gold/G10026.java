package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class G10026 {

  static int N;
  static char[][] map;
  static boolean[][] visit;
  static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(br.readLine());
    visit = new boolean[N][N];
    map = new char[N][N];
    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i][j] = s.charAt(j);
      }
    }

    int n = nonWeak();

    visit = new boolean[N][N];
    int y = colorWeak();

    sb.append(n).append(" ").append(y);
    System.out.println(sb);

  } // main

  static int nonWeak() {
    int cnt = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visit[i][j]){
          bfs1(i, j);
          cnt++;
        }
      }
    }
    return cnt;
  } // nonWeak

  static int colorWeak() {
    int cnt = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visit[i][j]){
          bfs2(i, j);
          cnt++;
        }
      }
    }
    return cnt;
  } // colorWeak

  static void bfs1(int y, int x) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{x, y});
    visit[y][x] = true;

    while (!q.isEmpty()) {
      int[] now = q.poll();
      int xx = now[0];
      int yy = now[1];

      for (int i = 0; i < 4; i++) {
        int nx = xx + dx[i];
        int ny = yy + dy[i];

        if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
        if (visit[ny][nx]) continue;

        if (map[yy][xx] == map[ny][nx]) {
          q.add(new int[]{nx, ny});
          visit[ny][nx] = true;
        }
      }
    }
  } // bfs1

  static void bfs2(int y, int x) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{x, y});
    visit[y][x] = true;

    while (!q.isEmpty()) {
      int[] now = q.poll();
      int xx = now[0];
      int yy = now[1];

      for (int i = 0; i < 4; i++) {
        int nx = xx + dx[i];
        int ny = yy + dy[i];

        if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
        if (visit[ny][nx]) continue;

        if (map[yy][xx] == 'R' || map[yy][xx] == 'G') {
          if (map[ny][nx] == 'R' || map[ny][nx] == 'G') {
            q.add(new int[]{nx, ny});
            visit[ny][nx] = true;
          }
        } else {
          if (map[yy][xx] == map[ny][nx]) {
            q.add(new int[]{nx, ny});
            visit[ny][nx] = true;
          }
        }
      }
    }
  } // bfs2

} // class
