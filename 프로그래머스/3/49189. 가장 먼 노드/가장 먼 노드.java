import java.util.*;

class Solution {
    
    static int n;
    static int[] distance;
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    
    public int solution(int n, int[][] edge) {
        this.n = n;
        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        visited = new boolean[n + 1];
        list = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edge.length; i++){
            int s = edge[i][0];
            int e = edge[i][1];
            
            list[s].add(e);
            list[e].add(s);
        }
        
        bfs(1);
        
        int max = 0;
        int answer = 0;
        for(int i = 1; i <= n; i++){
            max = Math.max(max, distance[i]);
        }
        for(int i = 1; i <= n; i++){
            if(max == distance[i]) answer++;
        }
        
        return answer;
    }
    
    static void bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;
        distance[start] = 0;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int i = 0; i < list[now].size(); i++){
                int next = list[now].get(i);
                
                if(visited[next]) continue;
                
                if(distance[next] > distance[now] + 1){
                    distance[next] = distance[now] + 1;
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}