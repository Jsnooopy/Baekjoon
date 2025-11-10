package lv2;

import java.io.*;
import java.util.*;

class Donut {

  static int nodeCnt, edgeCnt, donut, stick, eight;
  static int[] in, out;
  static ArrayList<Integer>[] list;
  static boolean[] visit;

  public int[] solution(int[][] edges) {
    in = new int[1000001];
    out = new int[1000001];
    list = new ArrayList[1000001];
    visit = new boolean[1000001];
    for(int i = 0; i < 1000001; i++){
      list[i] = new ArrayList<>();
    }

    for(int i = 0; i < edges.length; i++){
      int from = edges[i][0];
      int to = edges[i][1];

      list[from].add(to);
      out[from]++;
      in[to]++;
    }

    int num = 0;
    for(int i = 1; i < 1000001; i++){
      if(in[i] == 0 && out[i] >= 2) {
        num = i;
        break;
      }
    }

    for (int next : list[num]) {
      edgeCnt = 0;
      nodeCnt = 0;
      dfs(next);

      if (nodeCnt == edgeCnt) donut++;
      else if (nodeCnt > edgeCnt) stick++;
      else eight++;
    }

    int[] answer = {num, donut, stick, eight};
    return answer;
  }

  static void dfs(int start){
    if(visit[start]) return;
    visit[start] = true;

    nodeCnt++;
    edgeCnt += list[start].size();

    for(int next : list[start]){
      dfs(next);
    }

    return;
  }
}