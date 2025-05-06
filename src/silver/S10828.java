package silver;

import java.io.*;
import java.util.Stack;

public class S10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String s = br.readLine();

            if (s.contains("push")) {
                String split[] = s.split(" ");
                stack.push(Integer.parseInt(split[1]));
            } else if (s.contains("pop")) {
                if (stack.empty()) {
                    bw.write(-1 + "\n");
                }
                else {
                    bw.write(stack.pop() + "\n");
                }
            } else if (s.contains("size")) {
                bw.write(stack.size() + "\n");
            } else if (s.contains("empty")) {
                if (stack.empty()) {
                    bw.write(1 + "\n");
                }
                else {
                    bw.write(0 + "\n");
                }
            } else if (s.contains("top")) {
                if (stack.empty()) {
                    bw.write(-1 + "\n");
                }
                else {
                    bw.write(stack.peek() + "\n");
                }
            }
        }
        bw.flush();
    }
}
