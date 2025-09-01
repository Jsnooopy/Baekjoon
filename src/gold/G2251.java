package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G2251 {
	
	static boolean[][] visit;
	static boolean[] answer;
	static int[] now;
	static int[] send = {0, 0, 1, 1, 2, 2};
	static int[] recieve = {1, 2, 0, 2, 0, 1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		visit = new boolean[201][201];
		answer = new boolean[201];
		now = new int[3];
		
		now[0] = Integer.parseInt(st.nextToken());
		now[1] = Integer.parseInt(st.nextToken());
		now[2] = Integer.parseInt(st.nextToken());
		
		bfs();
		
		for(int i = 0; i < answer.length; i++) {
			if(answer[i]) System.out.print(i + " ");
		}
		
	} // main
	
	static void bfs() {
		Queue<AB> q = new LinkedList<>();
		q.add(new AB(0, 0));
		visit[0][0] = true;
		answer[now[2]] = true;
		
		while(!q.isEmpty()) {
			AB ab = q.poll();
			
			int A = ab.A;
			int B = ab.B;
			int C = now[2] - A - B;
			
			for(int i = 0; i < 6; i++) {
				int[] next = {A, B, C};
				next[recieve[i]] += next[send[i]];
				next[send[i]] = 0;
				if(next[recieve[i]] > now[recieve[i]]) {
					next[send[i]] = next[recieve[i]] - now[recieve[i]];
					next[recieve[i]] = now[recieve[i]];
				}
				
				if(!visit[next[0]][next[1]]) {
					visit[next[0]][next[1]] = true;
					q.add(new AB(next[0], next[1]));
					
					if(next[0] == 0) answer[next[2]] = true;
				}
			}
			
		}
	} // bfs

} // class

class AB {
	int A;
	int B;
	public AB(int A, int B) {
		this.A = A;
		this.B = B;
	}
}
