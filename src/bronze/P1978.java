package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] numbersStr = br.readLine().split(" ");
        int count = 0;

        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(numbersStr[i]);
            if (num == 1) continue;
            boolean check = true;

            for (int j=2; j<num; j++) {
                if (num % j == 0) {
                    check = false;
                    break;
                }
            }

            if (check) count++;
        }

        System.out.println(count);
        br.close();
    }
}
