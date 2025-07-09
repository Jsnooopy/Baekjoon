package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class G14226 {
    static int S;
    static boolean[][] visit;
    static Queue<emo> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = Integer.parseInt(br.readLine());
        visit = new boolean[2001][2001];

        bfs(new emo(1, 0, 0));
    }

    static void bfs(emo start) {
        q.add(start);

        while (!q.isEmpty()) {
            start = q.poll();

            if (start.now == S) {
                System.out.println(start.cnt);
                break;
            }

            if (!visit[start.now][start.now]) {
                visit[start.now][start.now] = true;
                q.add(new emo(start.now, start.now, start.cnt + 1));
            }

            if (start.clip != 0 && start.now + start.clip <= 2000) {
                if (!visit[start.now + start.clip][start.clip]) {
                    visit[start.now + start.clip][start.clip] = true;
                    q.add(new emo(start.now + start.clip, start.clip, start.cnt + 1));
                }
            }

            if (start.now > 0) {
                if (!visit[start.now - 1][start.clip]) {
                    visit[start.now - 1][start.clip] = true;
                    q.add(new emo(start.now - 1, start.clip, start.cnt + 1));
                }
            }
        }
    }

    static class emo {
        int now, clip, cnt;

        public emo(int now, int clip, int cnt) {
            this.now = now;
            this.clip = clip;
            this.cnt = cnt;
        }
    }
}
