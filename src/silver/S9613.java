package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            long sum = 0;

            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < n - 1; j++) {
                for (int k = 1; k < n - j; k++) {
                    sum += gcd(arr[j], arr[j + k]);
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }

    static int gcd(int A, int B) {
        if (B == 0) {
            return A;
        } else {
            return gcd(B, A % B);
        }
    }
}
