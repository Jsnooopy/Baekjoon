package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        long[] S = new long[N];
        long[] C = new long[M];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        S[0] = arr[0];

        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + arr[i];
        }

        long cnt = 0;
        for (int i = 0; i < N; i++) {
            int remainder = (int) (S[i] % M);

            if (remainder == 0) {
                cnt++;
            }

            C[remainder]++;
        }

        for (int i = 0; i < M; i++) {
            if (C[i] > 1) {
                cnt += C[i] * (C[i] - 1) / 2;
            }
        }

        System.out.println(cnt);
    }
}
