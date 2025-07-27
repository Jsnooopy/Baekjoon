package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }

        for (int i = 0; i < s.length(); i++) {
            int max = 0;
            for (int j = i; j < s.length(); j++) {
                max = Math.max(max, arr[j]);
            }

            for (int j = i; j < s.length(); j++) {
                if (max == arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            sb.append(arr[i]);
        }

        System.out.println(sb);
    }
}
