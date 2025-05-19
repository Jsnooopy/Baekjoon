package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        sb.append(fac(N));

        System.out.println(sb);
    }

    static int fac(int N) {
        if (N < 1) {
            return 1;
        } else {
            return N * fac(N - 1);
        }
    }
}
