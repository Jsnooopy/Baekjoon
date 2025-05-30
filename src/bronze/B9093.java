package bronze;

import java.io.*;
import java.util.Stack;

public class B9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        while(T-- > 0) {
            String s = br.readLine() + "\n";
            for(char c : s.toCharArray()) {
                if(c == ' ' || c == '\n') {
                    while(!stack.isEmpty()) {
                        bw.write(stack.pop());
                    }
                    bw.write(c); // 공백
                } else
                    stack.push(c);
            }
        }
        bw.flush();
    }
}
