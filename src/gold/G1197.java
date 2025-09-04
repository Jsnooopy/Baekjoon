package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class G1197 {

	static class Edge{
		int start, end, cost;
		
		Edge(int start, int end, int cost){
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	} // Edge (Inner)
	
	static int V, E;
	static Edge[] list;
	static int[] parent;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parent = new int[V + 1];
		for(int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		
		list = new Edge[E + 1];
		for(int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[i] = new Edge(s, e, c);
		}
		
		Arrays.sort(list, 1, E + 1, Comparator.comparingInt(e -> e.cost));
		
		long sum = 0;
		for(int i = 1; i <= E; i++) {
			Edge edge = list[i];
			
			if(find(edge.start) != find(edge.end)) {
				sum += edge.cost;
				union(list[i]);
			}
		}
		
		System.out.println(sum);
	} // main

	static void union(Edge e) {
		int start = find(e.start);
		int end = find(e.end);
		
		if(start != end) parent[end] = start;
	} // union
	
	static int find(int num) {
		if(num == parent[num]) return num;
		else return parent[num] = find(parent[num]);
	} // find
	
} // class
