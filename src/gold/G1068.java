package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G1068 {
	
	static int N;
	static ArrayList<Integer>[] tree;
	static boolean[] delete;
	static int[] parent;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		delete = new boolean[N];
		parent = new int[N];
		tree = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			
			if(a != -1) {
				tree[a].add(i);
				parent[i] = a;
			}
		}
		
		int D = Integer.parseInt(br.readLine());
		clear(D);
		if(tree[parent[D]].size() == 1) tree[parent[D]].remove(0);
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			if(tree[i].isEmpty() && !delete[i]) cnt++;
		}
		
		System.out.println(cnt);
		
	} // main
	
	static void clear(int node) {
		if(!tree[node].isEmpty()) {
			for(int i = 0; i < tree[node].size(); i++) {
				int child = tree[node].get(i);
				clear(child);
			}
		}
		tree[node].clear();
		delete[node] = true;
	} // clear

} // class
