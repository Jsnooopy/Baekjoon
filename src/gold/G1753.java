package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G1753 {
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		int[] distance = new int[V + 1];
		boolean[] visit = new boolean[V + 1];
		ArrayList<Edge>[] list = new ArrayList[V + 1];
		for(int i = 0; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 1; i <= V; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[u].add(new Edge(v, w));
		}
		
		PriorityQueue<Edge> q = new PriorityQueue<>();
		
		q.add(new Edge(K, 0));
		distance[K] = 0;
		
		while(!q.isEmpty()) {
			Edge now = q.poll();
			int nv = now.vertex;
			
			if(visit[nv]) continue;
			
			visit[nv] = true;
			for(int i = 0; i < list[nv].size(); i++) {
				Edge temp = list[nv].get(i);
				int next = temp.vertex;
				int value = temp.value;
				if(distance[next] > distance[nv] + value) {
					distance[next] = value + distance[nv];
					q.add(new Edge(next, distance[next]));
				}
			}
		}
		
		for(int i = 1; i <= V; i++) {
			if(visit[i]) System.out.println(distance[i]);
			else System.out.println("INF");
		}
		
	} // main

} // class

class Edge implements Comparable<Edge>{
	int vertex, value;
	Edge(int vertex, int value){
		this.vertex = vertex;
		this.value = value;
	}
	
	public int compareTo(Edge e) {
		if(this.value > e.value) return 1;
		else return -1;
	}
}
