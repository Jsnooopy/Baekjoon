package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int N = Integer.parseInt(s);
        int M = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[10];

        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                arr[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int result = Math.abs(N - 100);

        for (int i = 0; i < 1000000; i++) {
            String num = String.valueOf(i);

            boolean check = false;

            for (int j = 0; j < num.length(); j++) {
                if (arr[num.charAt(j) - '0']) {
                    check = true;
                    break;
                }
            }

            if (!check) {
                int min = Math.abs(N - i) + num.length();
                result = Math.min(result, min);
            }
        }
        System.out.println(result);
    }
}
