package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G15644 {
	
	static class Node{
		int rx, ry, bx, by, cnt;
		String s;
		
		Node(int rx, int ry, int bx, int by, int cnt, String s){
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.cnt = cnt;
			this.s = s;
		}
	}

	static String result;
	static int ox, oy;
	static char[][] board;
	static boolean[][][][] visit;
	static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
	
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
		
		
		System.out.println(bfs(rx, ry, bx, by, 1, ""));
		if(result != null) System.out.println(result);
		
	} // main

	static int bfs(int rx, int ry, int bx, int by, int c, String s) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(rx, ry, bx, by, c, s));
		visit[ry][rx][by][bx] = true;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			int nowRx = now.rx;
			int nowRy = now.ry;
			int nowBx = now.bx;
			int nowBy = now.by;
			int nowCnt = now.cnt;
			String nowS = now.s;
			
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
				if(!B && R) {
					if(i == 0) {
						result = nowS + "U";
					} else if(i == 1) {
						result = nowS + "D";
					} else if(i == 2) {
						result = nowS + "L";
					} else {
						result = nowS + "R";
					}
					
					return nowCnt;
				}
				
				if(nextRx == nextBx && nextRy == nextBy) {
					if(i == 0) {
						if(nowRy < nowBy) nextBy -= dy[i];
						else nextRy -= dy[i];
					} // 상
					else if(i == 1) {
						if(nowRy < nowBy) nextRy -= dy[i];
						else nextBy -= dy[i];
					} // 하
					else if(i == 2) {
						if(nowRx < nowBx) nextBx -= dx[i];
						else nextRx -= dx[i];
					} // 좌
					else {
						if(nowRx < nowBx) nextRx -= dx[i];
						else nextBx -= dx[i];
					} // 우
				}
				
				if(!visit[nextRy][nextRx][nextBy][nextBx]) {
					visit[nextRy][nextRx][nextBy][nextBx] = true;
					
					if(i == 0) {
						q.add(new Node(nextRx, nextRy, nextBx, nextBy, nowCnt + 1, nowS + "U"));
					} else if(i == 1) {
						q.add(new Node(nextRx, nextRy, nextBx, nextBy, nowCnt + 1, nowS + "D"));
					} else if(i == 2) {
						q.add(new Node(nextRx, nextRy, nextBx, nextBy, nowCnt + 1, nowS + "L"));
					} else {
						q.add(new Node(nextRx, nextRy, nextBx, nextBy, nowCnt + 1, nowS + "R"));
					}
				}
			}
		}
		
		return -1;
	} // bfs
	
} // class
