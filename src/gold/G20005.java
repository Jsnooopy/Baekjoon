package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class G20005 {
  static int hp;
  static int M;
  static int N;
  static int P;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    M = Integer.parseInt(input[0]);
    N = Integer.parseInt(input[1]);
    P = Integer.parseInt(input[2]);
    Pair[] players = new Pair[P];
    int[] dps = new int[P];

    char[][] map = new char[M][N];
    for(int i=0; i<M; i++) {
      String str = br.readLine();

      for(int j=0; j<N; j++) {
        map[i][j] = str.charAt(j);

        if(map[i][j]>='a' && map[i][j]<='z') {
          players[map[i][j]-'a'] = new Pair(i, j, 0, 0);
          map[i][j] = '.';
        }
      }
    }

    for(int i=0; i<P; i++) {
      String[] str = br.readLine().split(" ");
      dps[i] = Integer.parseInt(str[1]);
    }
    hp = Integer.parseInt(br.readLine());

    bfs(map, dps, players);
  }

  public static void bfs(char[][] map, int[] dps, Pair[] players) {
    Queue<Pair> queue = new LinkedList<>();
    PriorityQueue<Fight> pq = new PriorityQueue<>();
    boolean[][] visited;

    for(int i=0; i<P; i++) {
      Pair p = players[i];
      visited = new boolean[M][N];
      visited[p.x][p.y] = true;
      queue.add(new Pair(p.x, p.y , 0, i));

      while(!queue.isEmpty()) {
        Pair temp = queue.poll();

        if(map[temp.x][temp.y]=='B') {
          pq.add(new Fight(temp.idx, temp.t));
          break;
        }

        for(int j=0; j<4; j++) {
          int nx = temp.x+dx[j];
          int ny = temp.y+dy[j];

          if(nx<0 || nx>=M || ny<0 || ny>=N || visited[nx][ny] || map[nx][ny]=='X') continue;

          visited[nx][ny] = true;
          queue.add(new Pair(nx, ny, temp.t+1, temp.idx));
        }
      }

      queue.clear();
    }

    Fight f = pq.poll();

    int temp_time = f.t;
    int temp_dps = dps[f.idx];
    int ans = 1;

    while(!pq.isEmpty()) {
      f = pq.poll();
      hp -= temp_dps*(f.t-temp_time);
      temp_time = f.t;

      if(hp<0) {
        System.out.println(ans);
        return;
      }
      temp_dps += dps[f.idx];
      ans++;
    }

    System.out.println(ans);
  }

  public static class Pair {
    int x;
    int y;
    int t;
    int idx;

    public Pair(int x, int y, int t, int idx) {
      this.x = x;
      this.y = y;
      this.t = t;
      this.idx = idx;
    }
  }

  public static class Fight implements Comparable<Fight> {
    int idx;
    int t;

    public Fight(int idx, int t) {
      this.idx = idx;
      this.t = t;
    }

    public int compareTo(Fight f) {
      return this.t > f.t ? 1 : -1;
    }
  }
}