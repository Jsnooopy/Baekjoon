package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S11725 {
	
	static int N;
	static ArrayList<Integer>[] tree;
	static int[] result;
	static boolean[] visit;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        result = new int[N + 1];
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
        
        dfs(1);
        
        for(int i = 2; i <= N; i++) {
        	sb.append(result[i]).append("\n");
        }
        
        System.out.println(sb);
    }
    
    static void dfs(int parent) {
    	visit[parent] = true;
    	
    	for(int i = 0; i < tree[parent].size(); i++) {
    		int child = tree[parent].get(i);
    		
    		if(visit[child]) continue;
    		
    		result[child] = parent;
    		dfs(child);
    	}
    }
}
