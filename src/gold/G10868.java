package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G10868 {

	static int N, M, X, x;
	static int[] seg;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		while((int) Math.pow(2, x) <= N) {
			x++;
		}
		X = (int) Math.pow(2, x);
		
		seg = new int[X * 2];
		for(int i = X; i < X + N; i++) {
			seg[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = X + N; i < X * 2; i++) {
			seg[i] = Integer.MAX_VALUE;
		}
		
		for(int i = X - 1; i > 0; i--) {
			seg[i] = Math.min(seg[i * 2], seg[(i * 2) + 1]);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println(findMin(a + X - 1, b + X - 1));
		}
		
		
	} // main
	
	static int findMin(int start, int end) {
		int min = Integer.MAX_VALUE;
		
		while(start <= end) {
			if(start % 2 == 1) {
				min = Math.min(min, seg[start]);
				start++;
			}
			
			if(end % 2 == 0) {
				min = Math.min(min, seg[end]);
				end--;
			}
			
			start /= 2;
			end /= 2;
		}
		
		return min;
	} // findMin
	
} // class
