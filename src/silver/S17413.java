package silver;

import java.io.*;
import java.util.Stack;

public class S17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String S = br.readLine();
        int len = S.length();
        Stack<Character> stack = new Stack<>();

        boolean tag = false;

        for (int i = 0; i < len; i++) {
            if(S.charAt(i) == '<'){
                tag = true;
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(S.charAt(i));
            } else if (S.charAt(i) == '>') {
                tag = false;
                sb.append(S.charAt(i));
            } else if (tag) {
                sb.append(S.charAt(i));
            } else if (!tag) {
                if (S.charAt(i) == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(S.charAt(i));
                } else {
                    stack.push(S.charAt(i));
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
