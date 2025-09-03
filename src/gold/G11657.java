package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G11657 {
	static int N, M;
	static Edge[] edges;
	static long[] distance;
	
	static class Edge{
		int start, end, time;
		
		Edge(int start, int end, int time){
			this.start = start;
			this.end = end;
			this.time = time;
		}
	} // Inner class Edge

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		distance = new long[N + 1];
		edges = new Edge[M + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(A, B, C);
		}
		
		BF(1);
	} // main
	
	static void BF(int startCity) {
		distance[startCity] = 0;
		
		for(int i = 0; i < N - 1; i++) {
			for(int j = 1; j <= M; j++) {
				Edge edge = edges[j];
				if(distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.time) {
					distance[edge.end] = distance[edge.start] + edge.time;
				}
			}
		}
		
		boolean minus = false;
		
		for(int i = 1; i <= M; i++) {
			Edge edge = edges[i];
			
			if(distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.time) {
				minus = true;
			}
		}
		
		if(minus) System.out.println(-1);
		else {
			for(int i = 2; i <= N; i++) {
				if(distance[i] != Integer.MAX_VALUE) System.out.println(distance[i]);
				else System.out.println(-1);
			}
		}
	} // BF

} // class