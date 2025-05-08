package silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class S10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int back = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            if (s.contains("push")) {
                String split[] = s.split(" ");
                back = Integer.parseInt(split[1]);
                queue.add(back);
            } else if (s.contains("pop")) {
                if (queue.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(queue.remove() + "\n");
                }
            } else if (s.contains("size")) {
                bw.write(queue.size() + "\n");
            } else if (s.contains("empty")) {
                if (queue.isEmpty()) {
                    bw.write(1 + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            } else if (s.contains("front")) {
                if (queue.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(queue.peek() + "\n");
                }
            } else if (s.contains("back")) {
                if (queue.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(back+ "\n");
                }
            }

        }
        bw.flush();
    }
}
