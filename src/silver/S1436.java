package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S1436 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num = 666;
		int cnt = 0;

		for (int i = 666; cnt < N; i++) {
			if (isAnswer(i)) {
				cnt++;
				if (cnt == N) {
					num = i;
				}
			}
		}
		System.out.println(num);
	}
	public static boolean isAnswer(int N) {
		int a = N;
		int b = N % 1000;

		while (a > 665) {
			if (b == 666) {
				return true;
			} else {
				a /= 10;
				b = a % 1000;
			}
		}
		return false;
	}
}