package silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }


        sb.append("<");

        int cnt = 0;

        while (!queue.isEmpty()) {
            cnt++;
            if (cnt == K) {
                sb.append(queue.poll());
                cnt = 0;
                if (!queue.isEmpty()) {
                    sb.append(", ");
                }
            } else {
                queue.add(queue.poll());
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
