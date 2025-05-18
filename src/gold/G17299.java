package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class G17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] cnt = new int[1_000_001];

        String[] split = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(split[i]);
            cnt[A[i]] += 1;
        }

        Stack<Integer> stack = new Stack<>();

        for (int j = 0; j < N; j++) {
            while (!stack.isEmpty() && cnt[A[stack.peek()]] < cnt[A[j]]) {
                A[stack.pop()] = A[j];
            }
            stack.push(j);
        }

        while (!stack.isEmpty()) {
            A[stack.pop()] = -1;
        }

        for (int k = 0; k < N; k++) {
            sb.append(A[k]).append(" ");
        }

        System.out.println(sb);

    }
}
