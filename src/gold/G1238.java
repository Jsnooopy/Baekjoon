package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G1238 {

	static class Edge implements Comparable<Edge>{
		int end, spend;
		
		Edge(int end, int spend){
			this.end = end;
			this.spend = spend;
		}
		
		public int compareTo(Edge e) {
			return this.spend > e.spend ? 1 : -1;
		}
	}
	
	static ArrayList<Edge>[] list;
	static int[] distance;
	static int N, M, X;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) list[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Edge(b, c));
		}
		
		int max = 0;
		
		for(int i = 1; i <= N; i++) {
			max = Math.max(max, go(i, 0, X) + go(X, 0, i));
		}
		
		System.out.println(max);
	} // main

	static int go(int s, int c, int e) {
		distance = new int[N + 1];
		for(int i = 1; i <= N; i++) distance[i] = Integer.MAX_VALUE;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(s, c));
		distance[s] = 0;
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			int now_a = now.end;
			
			for(int i = 0; i < list[now_a].size(); i++) {
				Edge temp = list[now_a].get(i);
				int next = temp.end;
				int time = temp.spend;
				
				if(distance[next] > distance[now_a] + time) {
					distance[next] = distance[now_a] + time;
					pq.add(new Edge(next, distance[next]));
				}
				
			}
		}
		
		return distance[e];
		
	} // go
	
} // class
