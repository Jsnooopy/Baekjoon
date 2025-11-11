package lv2;

import java.io.*;
import java.util.*;

class Taxi {

  static class Node implements Comparable<Node>{
    int end, cost;
    public Node(int end, int cost){
      this.end = end;
      this.cost = cost;
    }
    @Override
    public int compareTo(Node n){
      return this.cost - n.cost;
    }
  }

  static ArrayList<Node>[] list;
  static int N;

  public int solution(int n, int s, int a, int b, int[][] fares) {
    N = n;
    list = new ArrayList[n + 1];
    for(int i = 0; i <= n; i++) list[i] = new ArrayList<>();

    for(int[] f : fares){
      list[f[0]].add(new Node(f[1], f[2]));
      list[f[1]].add(new Node(f[0], f[2]));
    }

    int[] fromS = dijkstra(s);
    int[] fromA = dijkstra(a);
    int[] fromB = dijkstra(b);

    int answer = Integer.MAX_VALUE;
    for (int k = 1; k <= n; k++) {
      if (fromS[k] == Integer.MAX_VALUE || fromA[k] == Integer.MAX_VALUE || fromB[k] == Integer.MAX_VALUE) continue;

      answer = Math.min(answer, fromS[k] + fromA[k] + fromB[k]);
    }

    return answer;
  }

  static int[] dijkstra(int start){
    PriorityQueue<Node> pq = new PriorityQueue<>();
    int[] dist = new int[N + 1];
    boolean[] visit = new boolean[N + 1];

    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;
    pq.add(new Node(start, 0));

    while(!pq.isEmpty()){
      Node now = pq.poll();
      if (visit[now.end]) continue;
      visit[now.end] = true;

      for(Node next : list[now.end]){
        if (dist[next.end] > dist[now.end] + next.cost){
          dist[next.end] = dist[now.end] + next.cost;
          pq.add(new Node(next.end, dist[next.end]));
        }
      }
    }
    return dist;
  }
}

