package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G1865 {
	
	static class Road{
		int start, end, time;
		
		Road(int start, int end, int time){
			this.start = start;
			this.end = end;
			this.time = time;
		}
	}
	
	static int N, M, W;
	static boolean minus;
	static int[] distance;
	static ArrayList<Road> list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < TC; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			distance = new int[N + 1];
			list = new ArrayList<>();
			
			for(int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				
				list.add(new Road(S, E, T));
				list.add(new Road(E, S, T));
			}
			for(int j = 0; j < W; j++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				
				list.add(new Road(S, E, -T));
			}
			
			minus = false;
			
			Arrays.fill(distance, 0);
			go();
			check();
			
			if(minus) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
		
		System.out.println(sb);
	} // main
	
	static void go() {
		
		for(int j = 0; j < N - 1; j++) {
			for(int i = 0; i < list.size(); i++) {
				Road road = list.get(i);
				int now = road.start;
				int next = road.end;
				int spend = road.time;
				
				if(distance[now] != Integer.MAX_VALUE && distance[next] > distance[now] + spend) {
					distance[next] = distance[now] + spend;
				}
			}
		}
	} // go
	
	static void check() {
		for(int i = 0; i < list.size(); i++) {
			Road road = list.get(i);
			int now = road.start;
			int next = road.end;
			int spend = road.time;
			
			if(distance[now] != Integer.MAX_VALUE && distance[next] > distance[now] + spend) {
				minus = true;
				break;
			}
		}
	} // check

} // class
