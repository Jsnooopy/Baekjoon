package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G16724 {

  static int N, M, cnt;
  static char[][] map;
  static boolean[][] cycle;
  static int[][] visit; // 0: 미방문, 1: 방문중, 2: 완료

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new char[N][M];
    cycle = new boolean[N][M];
    visit = new int[N][M];

    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = s.charAt(j);
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (visit[i][j] == 0) {
          dfs(i, j);
        }
      }
    }

    System.out.println(cnt);
  }

  static boolean dfs(int y, int x) {
    if (visit[y][x] == 1) {
      cnt++;
      return true;
    }
    if (visit[y][x] == 2) {
      return cycle[y][x];
    }

    visit[y][x] = 1;

    int ny = y, nx = x;
    switch (map[y][x]) {
      case 'U': ny--; break;
      case 'D': ny++; break;
      case 'L': nx--; break;
      case 'R': nx++; break;
    }

    boolean result = dfs(ny, nx);
    visit[y][x] = 2;
    cycle[y][x] = result;
    return result;
  }
}
