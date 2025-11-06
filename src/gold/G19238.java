package gold;

import java.io.*;
import java.util.*;

public class G19238 {

  static class Passenger {
    int sy, sx, ey, ex;
    public Passenger(int sy, int sx, int ey, int ex) {
      this.sy = sy;
      this.sx = sx;
      this.ey = ey;
      this.ex = ex;
    }
  }

  static int N, M, fuel;
  static int[][] map;
  static List<Passenger> passengers;

  static int taxiY, taxiX;
  static int[] dy = {-1, 0, 0, 1};
  static int[] dx = {0, -1, 1, 0};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    fuel = Integer.parseInt(st.nextToken());

    map = new int[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine());
    taxiY = Integer.parseInt(st.nextToken());
    taxiX = Integer.parseInt(st.nextToken());

    passengers = new ArrayList<>();
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int sy = Integer.parseInt(st.nextToken());
      int sx = Integer.parseInt(st.nextToken());
      int ey = Integer.parseInt(st.nextToken());
      int ex = Integer.parseInt(st.nextToken());
      passengers.add(new Passenger(sy, sx, ey, ex));
    }

    while (!passengers.isEmpty()) {
      int[] pick = findNearestPassenger();
      if (pick == null) {
        System.out.println(-1);
        return;
      }

      int sy = pick[0];
      int sx = pick[1];
      int idx = pick[2];
      int distToPassenger = pick[3];

      if (fuel < distToPassenger) {
        System.out.println(-1);
        return;
      }

      taxiY = sy;
      taxiX = sx;
      fuel -= distToPassenger;

      Passenger p = passengers.get(idx);
      int distToDest = bfs(taxiY, taxiX, p.ey, p.ex);
      if (distToDest == -1 || fuel < distToDest) {
        System.out.println(-1);
        return;
      }

      fuel += distToDest;
      taxiY = p.ey;
      taxiX = p.ex;

      passengers.remove(idx);
    }

    System.out.println(fuel);
  }

  static int[] findNearestPassenger() {

    int[][] dist = new int[N + 1][N + 1];
    for (int i = 1; i <= N; i++)
      Arrays.fill(dist[i], -1);

    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{taxiY, taxiX});
    dist[taxiY][taxiX] = 0;

    while (!q.isEmpty()) {
      int[] cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int ny = cur[0] + dy[i];
        int nx = cur[1] + dx[i];
        if (ny <= 0 || nx <= 0 || ny > N || nx > N) continue;
        if (map[ny][nx] == 1) continue;
        if (dist[ny][nx] != -1) continue;

        dist[ny][nx] = dist[cur[0]][cur[1]] + 1;
        q.add(new int[]{ny, nx});
      }
    }

    int minDist = Integer.MAX_VALUE;
    int bestIdx = -1;
    int bestY = 0, bestX = 0;

    for (int i = 0; i < passengers.size(); i++) {
      Passenger p = passengers.get(i);
      int d = dist[p.sy][p.sx];
      if (d == -1) continue;

      if (d < minDist || (d == minDist && (p.sy < bestY || (p.sy == bestY && p.sx < bestX)))) {
        minDist = d;
        bestIdx = i;
        bestY = p.sy;
        bestX = p.sx;
      }
    }

    if (bestIdx == -1) return null;

    return new int[]{bestY, bestX, bestIdx, minDist};
  }

  static int bfs(int sy, int sx, int ey, int ex) {
    int[][] dist = new int[N + 1][N + 1];
    for (int i = 1; i <= N; i++)
      Arrays.fill(dist[i], -1);

    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{sy, sx});
    dist[sy][sx] = 0;

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      if (cur[0] == ey && cur[1] == ex)
        return dist[cur[0]][cur[1]];

      for (int i = 0; i < 4; i++) {
        int ny = cur[0] + dy[i];
        int nx = cur[1] + dx[i];

        if (ny <= 0 || nx <= 0 || ny > N || nx > N) continue;
        if (map[ny][nx] == 1) continue;
        if (dist[ny][nx] != -1) continue;

        dist[ny][nx] = dist[cur[0]][cur[1]] + 1;
        q.add(new int[]{ny, nx});
      }
    }

    return -1;
  }
}
