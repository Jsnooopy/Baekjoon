package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class G1922 {

	static class Edge{
		int start, end, cost;
		
		Edge(int start, int end, int cost){
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}
	
	static int N, M;
	static Edge[] list;
	static int[] parent;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parent = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		list = new Edge[M + 1];
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[i] = new Edge(a, b, c);
		}
		
		Arrays.sort(list, 1, M + 1, Comparator.comparingInt(e -> e.cost));
		
		int result = 0;
		for(int i = 1; i <= M; i++) {
			Edge edge = list[i];
			
			if(find(edge.start) != find(edge.end)) {
				union(edge.start, edge.end);
				result += edge.cost;
			}
		}
		
		System.out.println(result);
		
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) parent[b] = a;
	}
	
	static int find(int num) {
		if(num == parent[num]) return num;
		else return parent[num] = find(parent[num]);
	}

}
