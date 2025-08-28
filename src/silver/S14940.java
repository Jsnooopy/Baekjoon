package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S14940 {
	static int n, m, startn, startm;
	static int[][] map;
	static boolean[][] check;
	static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		check = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					startn = i;
					startm = j;
				}
			}
		}
		
		bfs(startm, startn);
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!check[i][j] && map[i][j] != 0) {
					map[i][j] = -1;
				}
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

	} // main
	
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		check[y][x] = true;
		q.add(new int[] {x, y, 0});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			map[now[1]][now[0]] = now[2];
			
			for(int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= m || ny >= n || check[ny][nx] || map[ny][nx] == 0) 
					continue;
				
				check[ny][nx] = true;
				q.add(new int[] {nx, ny, now[2] + 1});
			}
		}
	} // bfs

} // class
