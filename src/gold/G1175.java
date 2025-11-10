package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G1175 {

  static class Node{
    int x, y, d ,t, c;

    public Node(int x, int y, int d, int t, int c) {
      this.x = x;
      this.y = y;
      this.d = d;
      this.t = t;
      this.c = c;
    }
  }

  static int N, M, cCnt;
  static char[][] map;
  static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    Node n = null;
    Node[] end = new Node[2];
    int idx = 0;
    map = new char[N][M];
    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = s.charAt(j);
        if (map[i][j] == 'S') {
          n = new Node(j, i, -1, 0, 0);
        } else if (map[i][j] == 'C') {
          end[idx] = new Node(j, i, -1,0 , 0);
          idx++;
        }
      }
    }

    System.out.println(bfs(n, end));
  } // main

  static int bfs(Node start, Node[] end) {
    Queue<Node> q = new LinkedList<>();
    q.add(start);
    boolean[][][][] visit = new boolean[N][M][4][3];
    for (int i = 0; i < 4; i++) {
      visit[start.y][start.x][i][0] = true;
    }

    while (!q.isEmpty()) {
      Node now = q.poll();
      int x = now.x;
      int y = now.y;

      if(x == end[0].x && y == end[0].y && now.c != 1) now.c += 1;
      if(x == end[1].x && y == end[1].y && now.c != 2) now.c += 2;

      if(now.c == 3) return now.t;

      for (int i = 0; i < 4; i++) {
        if(now.d == i) continue;

        int nx = x + dx[i];
        int ny = y + dy[i];

        if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
        if(map[ny][nx] == '#' || visit[ny][nx][i][now.c]) continue;

        q.add(new Node(nx, ny, i, now.t + 1, now.c));
        visit[ny][nx][i][now.c] = true;
      }
    }

    return -1;
  } // bfs

} // class
