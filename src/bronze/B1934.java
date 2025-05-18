package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] gcd = new int[T];

        for (int i = 0; i < T; i++) {
            String[] split = br.readLine().split(" ");
            int A = Integer.parseInt(split[0]);
            int B = Integer.parseInt(split[1]);

            if (A < B) {
                gcd[i] = gcd(B, A);
            } else {
                gcd[i] = gcd(A, B);
            }

            sb.append(A * B / gcd[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
