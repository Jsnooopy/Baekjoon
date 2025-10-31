package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class G2665 {

  static class Node implements Comparable<Node>{
    int x, y, c;

    public Node(int x, int y, int c) {
      this.x = x;
      this.y = y;
      this.c = c;
    }

    @Override
    public int compareTo(Node n) {
      return this.c - n.c;
    }
  }

  static int n;
  static int result = Integer.MAX_VALUE;
  static int[][] room, distance;
  static boolean[][] visit;
  static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    room = new int[n][n];
    distance = new int[n][n];
    visit = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        distance[i][j] = Integer.MAX_VALUE;
      }
    }

    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      for (int j = 0; j < n; j++) {
        room[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
      }
    }

    System.out.println(go(0, 0, 0));
    br.close();
  } // main

  static int go(int x, int y, int c) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(x, y, c));
    visit[y][x] = true;

    while (!pq.isEmpty()) {
      Node now = pq.poll();

      for (int i = 0; i < 4; i++) {
        int nx = now.x + dx[i];
        int ny = now.y + dy[i];
        int nc = now.c;

        if (nx == n - 1 && ny == n - 1) {
          return nc;
        }

        if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
        if(visit[ny][nx]) continue;

        if (room[ny][nx] == 0) {
          nc++;
        }

        pq.add(new Node(nx, ny, nc));
        visit[ny][nx] = true;
      }
    }

    return 0;
  } // go

} // main class
