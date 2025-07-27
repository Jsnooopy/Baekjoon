package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class G17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(split[i]);
        }

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                A[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            A[stack.pop()] = -1;
        }

        for (int i = 0; i < N; i++) {
            sb.append(A[i]).append(" ");
        }

        System.out.println(sb);

    }
}
