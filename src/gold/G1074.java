package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G1074 {
	static int size;
	static int cnt;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		size = (int) Math.pow(2, N);

		Z(size, r, c);
		
		System.out.println(cnt);
		
	} // main
	
	static void Z(int size, int r, int c) {
		if(size == 1) {
			return;
		}
		
		if(r < size / 2 && c < size / 2) {
			size /= 2;
			
			Z(size, r, c);
		} // 1사분면 
		else if(r < size / 2 && c >= size /2) {
			cnt +=  size * size / 4;
			c -= size / 2;
			size /= 2;
			
			Z(size, r, c);
		} // 2사분면 
		else if(r >= size / 2 && c < size / 2) {
			cnt += size * size / 4 * 2;
			r -= size / 2;
			size /= 2;
			
			Z(size, r, c);
		} // 3사분면 
		else {
			cnt += size * size / 4 * 3;
			r -= size / 2;
			c -= size / 2;
			size /= 2;
			
			Z(size, r, c);
		} // 4사분면
		
	} // Z

} // class
