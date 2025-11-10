package gold;

import java.io.*;
import java.util.*;

public class G1240 {

  static class Node {
    int e, d;

    public Node(int e, int d) {
      this.e = e;
      this.d = d;
    }
  }

  static int N, M;
  static ArrayList<Node>[] tree;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    tree = new ArrayList[N + 1];
    for (int i = 0; i <= N; i++) {
      tree[i] = new ArrayList<>();
    }

    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());

      tree[s].add(new Node(e, d));
      tree[e].add(new Node(s, d));
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      sb.append(bfs(start, end)).append("\n");
    }

    System.out.print(sb);
  }

  static int bfs(int start, int end) {
    Queue<int[]> q = new LinkedList<>();
    boolean[] visit = new boolean[N + 1];

    q.add(new int[]{start, 0});
    visit[start] = true;

    while (!q.isEmpty()) {
      int[] now = q.poll();
      int cur = now[0];
      int dist = now[1];

      if (cur == end) return dist;

      for (Node next : tree[cur]) {
        if (!visit[next.e]) {
          visit[next.e] = true;
          q.add(new int[]{next.e, dist + next.d});
        }
      }
    }
    return 0;
  }
}
