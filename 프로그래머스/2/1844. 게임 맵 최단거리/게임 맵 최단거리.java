import java.io.*;
import java.util.*;

class Solution {
    
    static int N, M;
    static int[][] maps;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
    
    public int solution(int[][] maps) {
        this.maps = maps;
        N = maps.length;
        M = maps[0].length;
        visited = new boolean[N][M];
        
        return bfs(0, 0, 1);
    }
    
    static int bfs(int x, int y, int cnt){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, cnt});

        while(!q.isEmpty()){
            int[] now = q.poll();
            int now_x = now[0];
            int now_y = now[1];
            int now_cnt = now[2];
            
            if(now_x == M - 1 && now_y == N - 1) return now_cnt;
            
            if(visited[now_y][now_x]) continue;
            visited[now_y][now_x] = true;
            
            for(int i = 0; i < 4; i++){
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];
                
                if(next_x < 0 || next_y < 0 || next_x >= M || next_y >= N) continue;
                if(visited[next_y][next_x] || maps[next_y][next_x] == 0) continue;
                
                q.offer(new int[]{next_x, next_y, now_cnt + 1});
            }
        }
        
        return -1;
    }
}