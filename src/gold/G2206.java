package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G2206 {
	
	static int N, M, result;
	static int[][] map;
	static boolean[][][] visit;
	static int[] dx = {0, 0, -1 ,1}, dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N + 1][M + 1];
		visit = new boolean[N + 1][M + 1][2];
		for(int i = 1; i <= N; i++) {
			String s = br.readLine();
			for(int j = 1; j <= M; j++) {
				map[i][j] = s.charAt(j - 1) - '0';
			}
		}
		
		System.out.println(bfs(1, 1, 1, 0));
	} // main

	static int bfs(int y, int x, int d, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {y, x, d, c});
		visit[y][x][0] = true;
		visit[y][x][1] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int yy = now[0];
			int xx = now[1];
			int distance = now[2];
			int crash = now[3];
			
			if(yy == N && xx == M) return distance;
			
			for(int i = 0; i < 4; i++) {
				int ny = yy + dy[i];
				int nx = xx + dx[i];
				
				if(ny <= 0 || nx <= 0 || ny > N || nx > M) continue;
				if(visit[ny][nx][crash]) continue;
				
				if(map[ny][nx] == 0) {
					q.add(new int[] {ny, nx, distance + 1, crash});
				} else {
					if(crash == 0) {
						q.add(new int[] {ny, nx, distance + 1, 1});
					}
				}
				
				visit[ny][nx][crash] = true;
			}
			
		}
		
		return -1;
	} // bfs
	
} // class
