package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G13460 {
	
	static class Node {
		int rx, ry, bx, by, cnt;
		
		Node(int rx, int ry, int bx, int by, int cnt){
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.cnt = cnt;
		}
	}

	static int N, ox, oy;
	static char[][] board;
	static boolean[][][][] visit;
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int rx = 0, ry = 0, bx = 0, by = 0;
		visit = new boolean[N][M][N][M];
		board = new char[N][M];
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				board[i][j] = s.charAt(j);
				if(board[i][j] == 'R') {
					rx = j;
					ry = i;
				} else if(board[i][j] == 'B') {
					bx = j;
					by = i;
				} else if(board[i][j] == 'O') {
					ox = j;
					oy = i;
				}
			}
		}
		
		System.out.println(bfs(rx, ry, bx, by, 1));		
	} // main
	
	static int bfs(int rx, int ry, int bx, int by, int c) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(rx, ry, bx, by, c));
		visit[ry][rx][by][bx] = true;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			int nowRx = now.rx;
			int nowRy = now.ry;
			int nowBx = now.bx;
			int nowBy = now.by;
			int nowCnt = now.cnt;
			
			if(nowCnt > 10) return -1;
			
			for(int i = 0; i < 4; i++) {
				int nextRx = nowRx;
				int nextRy = nowRy;
				int nextBx = nowBx;
				int nextBy = nowBy;
				
				boolean R = false;
				while(board[nextRy + dy[i]][nextRx + dx[i]] != '#') {
					nextRy += dy[i];
					nextRx += dx[i];
					
					if(nextRy == oy && nextRx == ox) {
						R = true; 
						break;
					}
				}
				
				boolean B = false;
				while(board[nextBy + dy[i]][nextBx + dx[i]] != '#') {
					nextBy += dy[i];
					nextBx += dx[i];
					
					if(nextBy == oy && nextBx == ox) {
						B = true; 
						break;
					}
				}
				
				if(B) continue;
				if(!B && R) return nowCnt;
				
				if(nextRy == nextBy && nextRx == nextBx) {
					if(i == 0) {
						if(nowRy < nowBy) nextBy -= dy[i];
						else nextRy -= dy[i];
					} // 위쪽 
					else if(i == 1) {
						if(nowRx < nowBx) nextRx -= dx[i];
						else nextBx -= dx[i];
					} // 오른쪽
					else if(i == 2) {
						if(nowRy < nowBy) nextRy -= dy[i];
						else nextBy -= dy[i];
					} // 아래쪽
					else {
						if(nowRx < nowBx) nextBx -= dx[i];
						else nextRx -= dx[i];
					} // 왼쪽
				}
				
				if(!visit[nextRy][nextRx][nextBy][nextBx]) {
					visit[nextRy][nextRx][nextBy][nextBx] = true;
					q.add(new Node(nextRx, nextRy, nextBx, nextBy, nowCnt + 1));
				}
			}
		}
		
		return -1;
	} // bfs
	

} // class
