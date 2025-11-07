package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G2573 {

  static int N, M, cnt, count;
  static boolean flag;
  static int[][] iceberg, melt;
  static boolean[][] visit;
  static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
  static StringBuilder sb = new StringBuilder();


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    visit = new boolean[N][M];
    melt = new int[N][M];
    iceberg = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        iceberg[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    while (true) {
      for (int i = 0; i < N; i++) {
        Arrays.fill(melt[i], 0);
      }

      year();

      if (check()) {
        System.out.println(cnt);
        break;
      }

      if (flag) {
        System.out.println(0);
        break;
      }
    }
    System.out.println(sb);
  } // main

  static void year() {
    cnt++;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (iceberg[i][j] != 0) {
          int c = 0;

          for (int k = 0; k < 4; k++) {
            int ny = i + dy[k];
            int nx = j + dx[k];

            if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;

            if(iceberg[ny][nx] == 0) c++;
          }

          melt[i][j] = c;
        }
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if(iceberg[i][j] != 0) {
          iceberg[i][j] -= melt[i][j];
          if (iceberg[i][j] < 0)
            iceberg[i][j] = 0;
        }
      }
    }
  } // year

  static boolean check() {
    for (int i = 0; i < N; i++) {
      Arrays.fill(visit[i], false);
    }

    count = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (iceberg[i][j] != 0) {
          if(!visit[i][j]) bfs(i, j);
        }
      }
    }

    if(count == 0) flag = true;
    return count >= 2;
  } // check

  static void bfs(int y, int x) {
    count++;
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{x, y});
    visit[y][x] = true;

    while (!q.isEmpty()) {
      int[] now = q.poll();

      for (int i = 0; i < 4; i++) {
        int nx = now[0] + dx[i];
        int ny = now[1] + dy[i];

        if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
        if(visit[ny][nx] || iceberg[ny][nx] == 0) continue;


        q.add(new int[]{nx, ny});
        visit[ny][nx] = true;
      }
    }
  } // bfs

} // class
