package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S10972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (next(arr)) {
            for (int i = 0; i < N; i++) {
                sb.append(arr[i]).append(" ");
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }

    public static boolean next(int[] arr) {
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) {
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }

        int j = arr.length - 1;
        while (arr[j] <= arr[i - 1]) {
            j -= 1;
        }

        swap(arr, i - 1, j);

        j = arr.length - 1;
        while (i < j) {
            swap(arr, i, j);
            i += 1;
            j -= 1;
        }
        return true;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
