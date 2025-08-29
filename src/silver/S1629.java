package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1629 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long result = x(A, B, C);
		
		System.out.println(result);
	}
	
	static long x(int A, int B, int C) {
		if(A == 1 || B == 1) return A % C;
		
		long num = x(A, B / 2, C);
		
		if(B % 2 == 1) return (num * num % C) * A % C;
		
		return num * num % C;
	}

}
