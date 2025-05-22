package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S17087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Math.abs(S - Integer.parseInt(st.nextToken()));
        }

        int gcd = arr[0];

        for (int i = 1; i < N; i++) {
            gcd = gcd(gcd, arr[i]);
        }

        System.out.println(gcd);
    }

    static int gcd(int A, int B) {
        if (B == 0) {
            return A;
        } else {
            return gcd(B, A % B);
        }
    }
}
