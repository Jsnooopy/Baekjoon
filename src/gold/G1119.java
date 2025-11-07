package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G1119 {

  static class Component {
    int nodes;
    int edges;
    Component(int n, int e) {
      this.nodes = n;
      this.edges = e;
    }
  }

  static int N;
  static String[] adj;
  static boolean[] visit;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine().trim());

    adj = new String[N];
    for (int i = 0; i < N; i++) {
      adj[i] = br.readLine().trim();
    }

    if (N == 1) {
      System.out.println(0);
      return;
    }
    visit = new boolean[N];

    int compCnt = 0;
    long total = 0;

    for (int i = 0; i < N; i++) {
      if (!visit[i]) {
        compCnt++;
        Component c = dfs(i);

        int nodes = c.nodes;
        int edges = c.edges / 2;

        if (nodes == 1) {
          System.out.println(-1);
          return;
        }
        total += (edges - (nodes - 1));
      }
    }

    if (total >= compCnt - 1) {
      System.out.println(compCnt - 1);
    } else {
      System.out.println(-1);
    }
  } // main

  static Component dfs(int start) {
    int nCnt = 0;
    int eCnt = 0;

    visit[start] = true;
    nCnt++;

    for (int j = 0; j < N; j++) {
      if (adj[start].charAt(j) == 'Y') {
        eCnt++;
        if (!visit[j]) {
          Component next = dfs(j);
          nCnt += next.nodes;
          eCnt += next.edges;
        }
      }
    }
    return new Component(nCnt, eCnt);
  } // dfs
} // class
