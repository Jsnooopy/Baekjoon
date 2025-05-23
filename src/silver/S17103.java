package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S17103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[] arr = new int[1_000_001];

        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] == 0) {
                continue;
            }
            for (int j = 2 * i; j < arr.length; j += i) {
                arr[j] = 0;
            }
        }

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            int cnt = 0;

            if (num == 0) {
                break;
            }

            for (int j = 2; j <= num / 2; j++) {
                if (arr[j] != 0 && arr[num - j] != 0) {
                    cnt += 1;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
