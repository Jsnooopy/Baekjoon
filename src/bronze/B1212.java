package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String eight = br.readLine();

        for (int i = 0; i < eight.length(); i++) {
            int num = eight.charAt(i) - '0';

            if (num / 4 == 1) {
                sb.append(1);
                num -= 4;
            } else {
                sb.append(0);
            }

            if (num / 2 == 1) {
                sb.append(1);
                num -= 2;
            } else {
                sb.append(0);
            }

            if (num == 1) {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }

        for (int i = 0; i < 2; i++) {
            if (sb.charAt(0) == '0' && sb.length() != 1) {
                sb.deleteCharAt(0);
            }
        }

        System.out.println(sb);
    }
}
