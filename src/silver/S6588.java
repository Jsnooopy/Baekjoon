package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S6588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[1_000_001];

        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] == 0) {
                continue;
            }

            for (int j = i + i; j < arr.length; j += i) {
                arr[j] = 0;
            }
        }

        while (true) {
            int num = Integer.parseInt(br.readLine());
            boolean prime = false;

            if (num == 0) {
                break;
            }

            for (int i = 2; i <= num; i++) {
                if (arr[i] != 0 && arr[num - i] != 0) {
                    sb.append(num + " = " + i + " + " + (num - i)).append("\n");
                    prime = true;
                    break;
                }
            }

            if (!prime) {
                sb.append("Goldbach's conjecture is wrong.").append("\n");
            }
        }
        System.out.println(sb);
    }
}
