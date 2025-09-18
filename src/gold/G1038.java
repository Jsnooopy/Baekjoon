package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class G1038 {
	static List<Long> list = new ArrayList<>();
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		if(N <= 10) {
			System.out.print(N);
			return;
		} else if (N >= 1023) {
			System.out.print(-1);
			return;
		}

		for(int i = 0; i < 10; i++) {
			dfs(i);
		}

		Collections.sort(list);
		System.out.print(list.get(N));
	} // main

	private static void dfs(long num) {		
		list.add(num);		
		long modValue = num % 10;
		if(modValue == 0) {
			return;
		}
		
		for(long i = modValue - 1; i >= 0; i--) {
			long newValue = num * 10 + i;
			dfs(newValue);
		}
	} // dfs
	
} // class
