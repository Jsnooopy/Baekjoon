package silver;

import java.io.*;
import java.util.Stack;

public class S1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int top = 0;    //stack 가장 위에 있는 값

        while (N > 0) {
            int n = Integer.parseInt(br.readLine());

            if (n > top) {
                for (int i = top + 1; i <= n; i++) {
                    stack.push(i);
                    sb.append('+').append('\n');
                }
                top = n;
            } else if (stack.peek() != n) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append('-').append('\n');
            N--;
        }

        System.out.println(sb);
    }
}
