package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] split = br.readLine().split(" ");

        int A = Integer.parseInt(split[0]);
        int B = Integer.parseInt(split[1]);

        int gcd;

        if (A < B) {
            gcd = gcd(B, A);
        } else {
            gcd = gcd(A, B);
        }

        int lcm = A * B / gcd;

        sb.append(gcd).append("\n");
        sb.append(lcm).append("\n");

        System.out.println(sb);
    }

    public static int gcd(int A, int B){
        if (B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }
}
