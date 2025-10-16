package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G1766 {

  static int N, M;
  static ArrayList<Integer>[] list;
  static int[] degree;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    degree = new int[N + 1];
    list = new ArrayList[N + 1];
    for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int first = Integer.parseInt(st.nextToken());
      int second = Integer.parseInt(st.nextToken());

      list[first].add(second);
      degree[second]++;
    }

    for (int i = 1; i <= N; i++) if(degree[i] == 0) pq.add(i);

    while (!pq.isEmpty()) {
      int now = pq.poll();
      sb.append(now).append(" ");

      for (int j = 0; j < list[now].size(); j++) {
        int next = list[now].get(j);
        degree[next]--;
        if(degree[next] == 0) pq.add(next);
      }
    }

    System.out.println(sb);
  } // main

} // class
