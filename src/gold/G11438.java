package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G11438 {
	
	static int N, k;
	static ArrayList<Integer>[] tree;
	static int[] depth;
	static int[][] parent;
	static boolean[] visit;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		depth = new int[N + 1];
		visit = new boolean[N + 1];
		tree = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			tree[a].add(b);
			tree[b].add(a);
		}
		
		while((int) Math.pow(2, k) <= N) {
			k++;
		}
		parent = new int[k + 1][N + 1];
		
		bfs(1);
		
		for(int i = 1; i <= k; i++) {
			for(int j = 1; j <= N; j++) {
				parent[i][j] = parent[i - 1][parent[i - 1][j]];
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			System.out.println(lca(c, d));
		}
	} // main
	
	static void bfs(int node) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		
		visit[node] = true;
		int level = 1;
		int size = 1;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i = 0; i < tree[now].size(); i++) {
				int next = tree[now].get(i);
				
				if(!visit[next]) {
					visit[next] = true;
					q.add(next);
					parent[0][next] = now;
					depth[next] = level;
				}
			}
			
			cnt++;
			if(cnt == size) {
				cnt = 0;
				size = q.size();
				level++;
			}
		}
	} // bfs
	
	static int lca(int num1, int num2) {
		if(depth[num1] < depth[num2]) {
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		
		for(int i = k; i >= 0; i--) {
			if((int) Math.pow(2, i) <= depth[num1] - depth[num2]) {
				if(depth[num2] <= depth[parent[i][num1]]) {
					num1 = parent[i][num1];
				}
			}
		}
		
		for(int i = k; i >= 0; i--) {
			if(parent[i][num1] != parent[i][num2]) {
				num1 = parent[i][num1];
				num2 = parent[i][num2];
			}
		}
		
		return num1 == num2 ? num1 : parent[0][num1];
	} // lca

} // class
