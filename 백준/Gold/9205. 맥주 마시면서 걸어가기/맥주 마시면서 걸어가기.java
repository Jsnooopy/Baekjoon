import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Pos{
        int r, c;
        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static Pos[] arr;
    static int N, sr, sc, er, ec;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");

            sr = Integer.parseInt(st.nextToken());
            sc = Integer.parseInt(st.nextToken());
            arr = new Pos[N];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine()," ");
                arr[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine()," ");

            er = Integer.parseInt(st.nextToken());
            ec = Integer.parseInt(st.nextToken());

            if(bfs())
                sb.append("happy\n");
            else
                sb.append("sad\n");
        }

        System.out.print(sb);
    }
    static boolean bfs(){
        Queue<Pos> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        q.add(new Pos(sr, sc));

        while(!q.isEmpty()){
            Pos cur = q.poll();

            if(check(cur.r , cur.c, er, ec))
                return true;

            for(int i = 0; i < N; i++) {
                if (visited[i])
                    continue;
                Pos nxt = arr[i];

                if (check(cur.r, cur.c, nxt.r, nxt.c)) {
                    visited[i] = true;
                    q.offer(new Pos(nxt.r, nxt.c));
                }
            }
        }

        return false;
    }

    static boolean check(int sr, int sc, int er, int ec){
        int dis = Math.abs(sr - er) + Math.abs(sc - ec);
        if(dis <= 1000) return true;

        return false;
    }
}