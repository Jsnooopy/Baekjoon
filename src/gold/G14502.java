package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G14502 {
	
	static class Empty{
		int x, y;
		
		Empty(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static ArrayList<Empty> list, virus;
	static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		list = new ArrayList<>();
		virus = new ArrayList<>();
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) list.add(new Empty(j, i));
				if(map[i][j] == 2) virus.add(new Empty(j, i));
			}
		}
		
		int max = 0;
		int cnt = 0;
		
		for(int i = 0; i < list.size() - 2; i++) {
			for(int j = i + 1; j < list.size() - 1; j++) {
				for(int k = j + 1; k < list.size(); k++) {
					visit = new boolean[N][M];
					
					Empty e1 = list.get(i);
					Empty e2 = list.get(j);
					Empty e3 = list.get(k);
					
					map[e1.y][e1.x] = 1;
					map[e2.y][e2.x] = 1;
					map[e3.y][e3.x] = 1;
					
					for(int l = 0; l < virus.size(); l++) {
						Empty v = virus.get(l);
						bfs(v);
					}
					
					cnt = 0;
					for(int a = 0; a < N; a++) {
						for(int b = 0; b < M; b++) {
							if(map[a][b] == 0 && !visit[a][b]) cnt++;
						}
					}
					
					max = Math.max(max, cnt);
					
					map[e1.y][e1.x] = 0;
					map[e2.y][e2.x] = 0;
					map[e3.y][e3.x] = 0;
				}
			}
		}
		
		System.out.println(max);
		
		
	} // main
	
	static void bfs(Empty v) {
		Queue<Empty> q = new LinkedList<>();
		q.add(v);
		
		while(!q.isEmpty()) {
			Empty now = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
				
				if(map[ny][nx] == 0 && !visit[ny][nx]) {
					visit[ny][nx] = true;
					q.add(new Empty(nx, ny));
				}
			}
		}
		
		
	} // bfs
	
} // class
