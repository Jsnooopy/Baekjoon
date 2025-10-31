package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class G2151 {

  private static class Point implements Comparable<Point> {
    int x;
    int y;
    int c;
    int d;

    private Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    private Point(int x, int y, int d, int c) {
      this.x = x;
      this.y = y;
      this.d = d;
      this.c = c;
    }

    @Override
    public int compareTo(Point o) {
      return c - o.c;
    }
  }
  
  static int N;
  static int result = Integer.MAX_VALUE;
  static char[][] map;
  static Point[] doors;
  static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
  
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    map = new char[N][N];
    int idx = 0;
    doors = new Point[2];

    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i][j] = s.charAt(j);
        if (map[i][j] == '#') {
          doors[idx++] = new Point(i, j);
        }
      }
    }

    dijkstra(doors[0]);

    System.out.println(result);
    br.close();
  }

  static void dijkstra(Point p) {
    PriorityQueue<Point> pq = new PriorityQueue<>();
    boolean[][][] visit = new boolean[N][N][4];
    int[][][] distance = new int[N][N][4];
    
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        Arrays.fill(distance[i][j], Integer.MAX_VALUE);
      }
    }

    for (int i = 0; i < 4; i++) {
      pq.add(new Point(p.x, p.y, i, 0));
      distance[p.x][p.y][i] = 0;
    }

    while (!pq.isEmpty()) {
      Point now = pq.poll();

      if (doors[1].x == now.x && doors[1].y == now.y && map[now.x][now.y] == '#') {
        result = Math.min(result, now.c);
      }

      if (visit[now.x][now.y][now.d]) continue;
      if (distance[now.x][now.y][now.d] < now.c) continue;
      
      visit[now.x][now.y][now.d] = true;

      int nx = 0;
      int ny = 0;
      if (map[now.x][now.y] == '!') {
        for (int i = 1; i <= 3; i += 2) {
          int idx = (now.d + i) % 4;
          
          nx = dx[idx] + now.x;
          ny = dy[idx] + now.y;
          
          if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
          if(visit[nx][ny][idx] || map[nx][ny] == '*') continue;

          if (distance[nx][ny][idx] <= distance[now.x][now.y][now.d] + 1) continue;

          distance[nx][ny][idx] = distance[now.x][now.y][now.d] + 1;
          pq.add(new Point(nx, ny, idx, distance[nx][ny][idx]));
        }
      }

      nx = now.x + dx[now.d];
      ny = now.y + dy[now.d];

      if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
      if(visit[nx][ny][now.d] || map[nx][ny] == '*') continue;

      if (distance[nx][ny][now.d] <= distance[now.x][now.y][now.d]) continue;

      distance[nx][ny][now.d] = distance[now.x][now.y][now.d];
      pq.add(new Point(nx, ny, now.d, distance[nx][ny][now.d]));
    }
  }
  
} // class
