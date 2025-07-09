package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G13549 {
    static int N, K;
    static boolean[] visit;
    static Queue<loc> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visit = new boolean[100001];

        visit[N] = true;
        bfs(new loc(N, 0));
    }

    static void bfs(loc loc) {
        q.add(loc);

        while (!q.isEmpty()) {
            loc p = q.poll();

            if (p.now == K) {
                System.out.println(p.sec);
                break;
            }

            if (p.now * 2 < 100001 && !visit[p.now * 2]) {
                visit[p.now * 2] = true;
                q.add(new loc(p.now * 2, p.sec));
            }

            if (p.now - 1 >= 0 && !visit[p.now - 1]) {
                visit[p.now - 1] = true;
                q.add(new loc(p.now - 1, p.sec + 1));
            }

            if (p.now + 1 < 100001 && !visit[p.now + 1]) {
                visit[p.now + 1] = true;
                q.add(new loc(p.now + 1, p.sec + 1));
            }


        }
    }

    static class loc {
        int now;
        int sec;

        public loc(int now, int sec) {
            this.now = now;
            this.sec = sec;
        }
    }
}
