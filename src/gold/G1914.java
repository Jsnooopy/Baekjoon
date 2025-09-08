package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class G1914 {
	
	static ArrayList<int[]> list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		
		BigInteger result = BigInteger.valueOf(2).pow(N).subtract(BigInteger.ONE);
		
		System.out.println(result);

		if(N <= 20) {
			hanoi(N, 1, 3, 2);
			for(int i = 0; i < list.size(); i++) {
				int[] arr = list.get(i);
				System.out.println(arr[0] + " " + arr[1]);
			}
		} 
	} // main

	static void hanoi(int N, int start, int end, int via) {
		if(N == 1) list.add(new int[] {start, end});
		else {
			hanoi(N - 1, start, via, end);	
			list.add(new int[] {start, end});
			hanoi(N - 1, via, end, start);
		}
	} // hanoi
	
} // class
