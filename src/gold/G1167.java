package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class G1167 {
	
	static class Edge {
		int end, cost;
		
		Edge(int end, int cost){
			this.end = end;
			this.cost = cost;
		}
	}
	
	static int V;
	static ArrayList<Edge>[] list;
	static int[] distance;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		V = Integer.parseInt(br.readLine());
		
		list = new ArrayList[V + 1];
		for(int i = 0; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= V; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			while(true) {
				int b = Integer.parseInt(st.nextToken());
				if(b == -1) break;
				int c = Integer.parseInt(st.nextToken());
				list[a].add(new Edge(b, c));
			}
		}
		
		diameter(1);
		int farNode = 1;
		for(int i = 2; i <= V; i++) {
			if(distance[i] > distance[farNode]) farNode = i;
		}
		
		diameter(farNode);
		int result = 0;
		for(int i = 1; i <= V; i++) {
			result = Math.max(result, distance[i]);
		}
		System.out.println(result);
	} // main
	
	static void diameter(int num) {
		Queue<Integer> q = new LinkedList<>();
		visit = new boolean[V + 1];
		distance = new int[V + 1];
		q.add(num);
		visit[num] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(Edge e : list[now]) {
				if(!visit[e.end]) {
					visit[e.end] = true;
					distance[e.end] = distance[now] + e.cost;
					q.add(e.end);
				}
			}
		}
	}

} // class
