package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            int front = 0;
            int back = N - 1;

            while (front < back) {
                int sum = arr[front] + arr[back];
                if (sum > arr[i]) {
                    back--;
                } else if (sum < arr[i]) {
                    front++;
                } else if (sum == arr[i]) {
                    if (front != i && back != i) {
                        cnt++;
                        break;
                    } else if (front == i) {
                        front++;
                    } else if (back == i) {
                        back--;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
