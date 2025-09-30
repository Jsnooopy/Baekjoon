package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G14442 {
	
	static int N, M, K;
	static int[][] arr;
	static boolean[][][] visit;
	static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N + 1][M + 1][K + 1];
		arr = new int[N + 1][M + 1];
		for(int i = 1; i <= N; i++) {
			String s = br.readLine();
			for(int j = 1; j <= M; j++) {
				arr[i][j] = s.charAt(j - 1) - '0';
			}
		}
		
		System.out.println(bfs(1, 1, 1, 0));
		
	} // main
	
	static int bfs(int x, int y, int d, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y, d, c});
		for(int i = 0; i < K; i++) visit[y][x][i] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int distance = now[2];
			int crash = now[3];
			
			if(now[0] == M && now[1] == N) return distance;
			
			for(int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(nx <= 0 || ny <= 0 || nx > M || ny > N) continue;
				if(visit[ny][nx][crash]) continue;
				
				if(arr[ny][nx] == 0) q.add(new int[] {nx, ny, distance + 1, crash});
				else {
					if(crash < K) q.add(new int[] {nx, ny, distance + 1, crash + 1});
				}
				
				visit[ny][nx][crash] = true;
			}
			
		}
		
		return -1;
	} // dfs

} // class
