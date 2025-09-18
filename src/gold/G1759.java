package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G1759 {

	static int L, C;
	static char[] password, result;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		password = new char[C];
		visit = new boolean[C];
		result = new char[L];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			password[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(password);

		dfs(0, 0);
	}
	
	static void dfs(int num, int depth) {
		if(depth == L) {
			int vowel = 0;
			int consonent = 0;
			for(char c : result) {
				if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
					vowel++;
				}
				else consonent++;
				
				sb.append(c);
			}
			
			
			if(vowel >= 1 && consonent >= 2) {
				System.out.println(sb);
			}
			
			sb.delete(0, sb.length());
			return;
		}
		
		for(int i = num; i < C; i++) {
			if(!visit[i]) {
				visit[i] = true;
				result[depth] = password[i];
				dfs(i + 1, depth + 1);
				visit[i] = false;
			}
		}
		
		
	}

}
