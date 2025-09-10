package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G1967 {

	static class Edge{
		int end, cost;
		
		Edge(int end, int cost){
			this.end = end;
			this.cost = cost;
		}
	}
	
	static int n;
	static int[] distance;
	static boolean[] visit;
	static ArrayList<Edge>[] list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		distance = new int[n + 1];
		visit = new boolean[n + 1];
		list = new ArrayList[n + 1];
		for(int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		for(int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Edge(b, c));
			list[b].add(new Edge(a, c));
		}
		
		
		diameter(1);
		int farNode = 1;
		for(int i = 2; i <= n; i++) {
			if(distance[farNode] < distance[i]) farNode = i; 
		}
		
		diameter(farNode);
		int result = 0;
		for(int i = 1; i <= n; i++) {
			result = Math.max(result, distance[i]);
		}
		
		System.out.println(result);
		
	}

	static void diameter(int start) {
		Queue<Edge> q = new LinkedList<>();
		Arrays.fill(distance, 0);
		Arrays.fill(visit, false);
		q.add(new Edge(start, 0));
		
		while(!q.isEmpty()){
			Edge e = q.poll();
			int now = e.end;
			visit[now] = true;
			
			for(int i = 0; i < list[now].size(); i++) {
				Edge edge = list[now].get(i);
				int next = edge.end;
				int cost = edge.cost;
				
				if(!visit[next] && distance[next] < distance[now] + cost) {
					distance[next] = distance[now] + cost;
					q.add(new Edge(next, distance[next]));
				}
			}
		}
		
	}
}
