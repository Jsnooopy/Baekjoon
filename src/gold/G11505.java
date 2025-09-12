package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G11505 {

	static int N, M, K, X, x;
	static long[] seg;
	static int W = 1_000_000_007;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		while((int) Math.pow(2, x) < N) {
			x++;
		}
		X = (int) Math.pow(2, x);
		
		seg = new long[X * 2];
		for(int i = X; i < X + N; i++) {
			seg[i] = Integer.parseInt(br.readLine());
		}
		for(int i = X + N; i < X * 2; i++) {
			seg[i] = 1;
		}
		
		for(int i = X - 1; i > 0; i--) {
			seg[i] = seg[i * 2] % W * seg[(i * 2) + 1] % W;
		}
		
		for(int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == 1) changeNum(b + X - 1, c);
			else System.out.println(findMul(b + X - 1, c + X - 1));
		}
	} // main

	static void changeNum(int index, int num) {
		seg[index] = num;
		
		while(index > 1) {
			index /= 2;
			seg[index] = seg[index * 2] % W * seg[(index * 2) + 1] % W;
		}
	} // changeNum
	
	static long findMul(int start, int end) {
		long mul = 1;
		
		while(start <= end) {
			if(start % 2 == 1) {
				if(seg[start] == 0) return 0;
				mul = mul * seg[start] % W;
				start++;
			}
			if(end % 2 == 0) {
				if(seg[end] == 0) return 0;
				mul = mul * seg[end] % W;
				end--;
			}
			
			start /= 2;
			end /= 2;
		}
		
		return mul % W;
	} // findMul
	
} // class
