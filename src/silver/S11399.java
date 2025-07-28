package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            while (i > 0) {
                if (P[i] < P[i - 1]) {
                    int temp = P[i];
                    P[i] = P[i - 1];
                    P[i - 1] = temp;
                    i--;
                } else {
                    break;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += P[i] * (N - i);
        }

        System.out.println(sum);
    }
}
