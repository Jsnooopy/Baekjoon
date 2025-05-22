package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1373 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String binary = br.readLine();

        int sum = 0;

        for (int i = 0; i < binary.length(); i++) {
            int num = binary.charAt(i) - '0';

            if ((binary.length() - i) % 3 == 0) {
                sum += 4 * num;
            } else if ((binary.length() - i) % 3 == 1) {
                sum += num;
                sb.append(sum);
                sum = 0;
            } else {
                sum += 2 * num;
            }
        }

        System.out.println(sb);
    }
}
