package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class G1414 {
	
	static class Edge{
		int start, end, lan;
		
		Edge(int start, int end, int lan){
			this.start = start;
			this.end = end;
			this.lan = lan;
		}
	}
	
	static int N;
	static char[][] connect;
	static int[] parent;
	static ArrayList<Edge> list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		connect = new char[N][N];
		list = new ArrayList<>();
		parent = new int[N];
		
		for(int i = 0; i < N; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				connect[i][j] = s.charAt(j);
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(connect[i][j] == '0') continue;
				
				if(Character.isUpperCase(connect[i][j])) list.add(new Edge(i, j, connect[i][j] - 38));
				else list.add(new Edge(i, j, connect[i][j] - 96));
			}
		}
		
		Collections.sort(list, Comparator.comparingInt(e -> e.lan));
		
		int sum = 0;
		int useEdge = 0;
		for(int i = 0; i < list.size(); i++) {
			Edge edge = list.get(i);
			
			
			if(find(parent[edge.start]) != find(parent[edge.end])) {
				union(edge.start, edge.end);
				useEdge++;
			}
			else sum += edge.lan;
		}
		
		if(useEdge == N - 1) System.out.println(sum);
		else System.out.println(-1);
	} // main

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) parent[b] = a;
	}
	
	static int find(int num) {
		if(num == parent[num]) return num;
		else return parent[num] = find(parent[num]);
	}
	
} // class
