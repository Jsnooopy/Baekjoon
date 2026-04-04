import java.util.*;
import java.io.*;

class Solution {
    
    static class Vilage implements Comparable<Vilage> {
        int arrive, time;
        
        Vilage(int arrive, int time){
            this.arrive = arrive;
            this.time = time;
        }
        
        public int compareTo (Vilage v){
            return this.time > v.time ? 1 : -1;
        }
    }
    
    static ArrayList<Vilage>[] list;
    static int[] distance;
    static boolean[] visited;
    
    public int solution(int N, int[][] road, int K) {
        list = new ArrayList[N + 1];
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 1; i <= N; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        
        for(int i = 0; i < road.length; i++){
            int s = road[i][0];
            int e = road[i][1];
            int t = road[i][2];
            list[s].add(new Vilage(e, t));
            list[e].add(new Vilage(s, t));
        }
        
        deliver(1);
        
        int cnt = 0;
        for(int i = 1; i <= N; i++){            
            if(distance[i] <= K) cnt++;
        }
        
        return cnt;
    }
    
    static void deliver(int start){
        PriorityQueue<Vilage> pq = new PriorityQueue<>();
        pq.add(new Vilage(start, 0));
        distance[start] = 0;
        
        while(!pq.isEmpty()){
            Vilage now = pq.poll();
            
            int now_a = now.arrive;
            
            if(visited[now_a]) continue;
            visited[now_a] = true;
            
            for(int i = 0; i < list[now_a].size(); i++){
                Vilage next = list[now_a].get(i);
                int next_a = next.arrive;
                int next_t = next.time;
                
                if(distance[next_a] > distance[now_a] + next_t){
                    distance[next_a] = distance[now_a] + next_t;
                    pq.add(new Vilage(next_a, distance[next_a]));
                }
            }
        }
    }
}