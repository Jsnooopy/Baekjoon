package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G2042 {

	static int N, M, K, x, X;
	static long[] seg;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		while(true) {
			if((int) Math.pow(2, x) >= N) break;
			x++;
		}
		X = (int) Math.pow(2, x);
		
		seg = new long[X * 2];
		for(int i = X; i < X + N; i++) {
			seg[i] = Long.parseLong(br.readLine());
		}
		
		for(int i = X - 1; i > 0; i--) {
			seg[i] = seg[i * 2] + seg[(i * 2) + 1];
		}
		
		for(int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a == 1) changeNum(b, c);
			else System.out.println(findSum(b + X - 1, (int) c + X - 1));
		}
	} // main

	static void changeNum(int index, long num) {
		int temp = index + X - 1;
		seg[temp] = num;
		int parentIndex = temp / 2;
		
		while(parentIndex > 0) {
			seg[parentIndex] = seg[parentIndex * 2] + seg[(parentIndex * 2) + 1];
			parentIndex /= 2;
		}
	} // changeNum
	
	static long findSum(int start, int end) {
		long sum = 0;
		
		while(start <= end) {
			if(start % 2 == 1) {
				sum += seg[start];
				start++;
			}
			if(end % 2 == 0) {
				sum += seg[end];
				end--;
			}
			
			start /= 2;
			end /= 2;
		}
		
		return sum;
	} // findSum
	
} // class
