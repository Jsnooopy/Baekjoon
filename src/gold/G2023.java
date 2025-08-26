package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G2023 {
	static int input;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = Integer.parseInt(br.readLine());
		
		// 첫 자리에 올 수 있는 수가 소수 여야 하므로 2, 3, 5, 7 뿐
		dfs(2 ,1);
		dfs(3 ,1);
		dfs(5 ,1);
		dfs(7 ,1);
		
		System.out.println(sb);
		
	} // main
	
	
	static void dfs(int prime, int depth) {
		if(depth == input) {
			if(isPrime(prime)) {
				sb.append(prime).append("\n");
			}
			return;
		}
		
		for(int i = 1; i < 10; i++) {
			if(i % 2 == 0) {
				continue;
			} // 끝 자리가 짝수면 절대로 소수가 될 수 없음
			if(isPrime(prime * 10 + i)) {
				dfs(prime * 10 + i, depth + 1);
			}
		}
	} // dfs
	
	static boolean isPrime(int num) {
		for(int i = 2; i <= num / 2; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	} // isPrime
	
} // class
