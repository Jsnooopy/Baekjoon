package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G1504 {

	static class Edge implements Comparable<Edge>{
		int end, cost;
		
		Edge(int end, int cost){
			this.end = end;
			this.cost = cost;
		}
		
		public int compareTo(Edge e) {
			return this.cost > e.cost ? 1 : -1;
		}
	}
	
	static int N, M, node1, node2;
	static boolean check;
	static ArrayList<Edge>[] list;
	static int[] distance;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		distance = new int[N + 1];
		list = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Edge(b, c));
			list[b].add(new Edge(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		node1 = Integer.parseInt(st.nextToken());
		node2 = Integer.parseInt(st.nextToken());
		
		int result1 = go(1, node1) + go(node1, node2) + go(node2, N);
		int result2 = go(1, node2) + go(node2, node1) + go(node1, N);

		
		int result = Math.min(result1, result2);
		
		if(check) System.out.println(-1);
		else System.out.println(result);
	}

	static int go(int s, int e) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		distance[s] = 0;
		pq.add(new Edge(s, 0));
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int now = edge.end;
			
			for(int i = 0; i < list[now].size(); i++) {
				Edge temp = list[now].get(i);
				int next = temp.end;
				int cost = temp.cost;
				
				if(distance[next] > distance[now] + cost) {
					distance[next] = distance[now] + cost;
					pq.add(new Edge(next, distance[next]));
				}
			}
			
		}
		
		if(distance[e] == Integer.MAX_VALUE) check = true;
		
		return distance[e];
	}
	
}
