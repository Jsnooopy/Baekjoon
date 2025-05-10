package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                stack.pop();
                if (s.charAt(i - 1) == '(') {
                    cnt += stack.size();
                } else if (s.charAt(i - 1) == ')') {
                    cnt += 1;
                }
            }
        }
        System.out.println(cnt);
    }
}
