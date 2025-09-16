package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G2166 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		double[] x = new double[N + 1];
		double[] y = new double[N + 1];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Double.parseDouble(st.nextToken());
			y[i] = Double.parseDouble(st.nextToken());
		}
		x[N] = x[0];
		y[N] = y[0];
		
		double left = 0;
		double right = 0;
		
		for(int i = 0; i < N; i++) {
			right += x[i] * y[i + 1];
			left += y[i] * x[i + 1];
		}
		
		double result = Math.abs(right - left) / 2;
		
		System.out.printf("%.1f", result);
	} // main

} // class
