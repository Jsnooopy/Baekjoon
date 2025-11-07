package platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16930 {

  static class Node{
    int x, y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static int N, M, K;
  static char[][] gym;
  static int[][] dist;
  static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    dist = new int[N + 1][M + 1];
    gym = new char[N + 1][M + 1];
    for (int i = 1; i <= N; i++) {
      String s = br.readLine();
      Arrays.fill(dist[i], Integer.MAX_VALUE);
      for (int j = 1; j <= M; j++) {
        gym[i][j] = s.charAt(j - 1);
      }
    }

    st = new StringTokenizer(br.readLine());
    int x1 = Integer.parseInt(st.nextToken());
    int y1 = Integer.parseInt(st.nextToken());
    Node start = new Node(x1, y1);

    int x2 = Integer.parseInt(st.nextToken());
    int y2 = Integer.parseInt(st.nextToken());
    Node end = new Node(x2, y2);

    bfs(start, end);

    System.out.println(dist[end.x][end.y] == Integer.MAX_VALUE ? -1 : dist[end.x][end.y]);
  } // main

  static void bfs(Node start, Node end) {
    Queue<Node> q = new LinkedList<>();
    q.add(start);
    dist[start.x][start.y] = 0;

    while (!q.isEmpty()) {
      Node now = q.poll();

      if (now.x == end.x && now.y == end.y) return;

      for (int i = 0; i < 4; i++) {
        for (int k = 1; k <= K; k++) {
          int nx = now.x + dx[i] * k;
          int ny = now.y + dy[i] * k;
          
          if (nx <= 0 || ny <= 0 || nx > N || ny > M) break;
          if(gym[nx][ny] == '#') break;
          if (dist[nx][ny] < dist[now.x][now.y] + 1) break;

          if (gym[nx][ny] == '.' && dist[nx][ny] == Integer.MAX_VALUE) {
            q.add(new Node(nx, ny));
            dist[nx][ny] = dist[now.x][now.y] + 1;
          }
        }
      }
    }
  } // bfs

} // class
