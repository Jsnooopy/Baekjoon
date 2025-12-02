package gold;

import java.util.*;
import java.io.*;

public class G17070 {
  static int n;
  static int[][] graph;
  static int cnt = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    graph = new int[n][n];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dfs(0, 1, 0);
    System.out.println(cnt);
  }

  static void dfs(int y, int x, int dir) {
    if (y == n - 1 && x == n - 1) {
      cnt++;
      return;
    }

    if (dir == 0 || dir == 2) {
      if (x + 1 < n && graph[y][x + 1] == 0) {
        dfs(y, x + 1, 0);
      }
    }

    if (dir == 1 || dir == 2) {
      if (y + 1 < n && graph[y + 1][x] == 0) {
        dfs(y + 1, x, 1);
      }
    }

    if (x + 1 < n && y + 1 < n && graph[y][x + 1] == 0 && graph[y + 1][x] == 0 && graph[y + 1][x + 1] == 0) {
      dfs(y + 1, x + 1, 2);
    }
  }
}