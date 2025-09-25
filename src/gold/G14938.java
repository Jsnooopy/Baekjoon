package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G14938 {
	
	static class Node implements Comparable<Node>{
		int end, len;
		
		Node(int end, int len){
			this.end = end;
			this.len = len;
		}
		
		@Override
		public int compareTo(Node n) {
			return this.len - n.len;
		}
	}
	
	static int n, m, r, cnt;
	static ArrayList<Node>[] list;
	static int[] item;
	static boolean[] visit;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		item = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		
		list = new ArrayList[n + 1];
		for(int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b, l));
			list[b].add(new Node(a, l));
		}
		
		int max = 0;
		for(int i = 1; i <= n; i++) {
			find(i);
			max = Math.max(max, cnt);
		}
		
		System.out.println(max);
		
	} // main
	
	static void find(int start) {
		int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        cnt = 0;
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.len > dist[now.end]) continue;

            for (Node next : list[now.end]) {
                int newDist = now.len + next.len;
                if (newDist < dist[next.end]) {
                    dist[next.end] = newDist;
                    pq.add(new Node(next.end, newDist));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dist[i] <= m) cnt += item[i];
        }
        
	} // find

} // class
