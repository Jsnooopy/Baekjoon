import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Tree implements Comparable<Tree> {
        int row, col, age;

        Tree(int row, int col, int age){
            this.row = row;
            this.col = col;
            this.age = age;
        }

        @Override
        public int compareTo(Tree t){
            return this.age - t.age;
        }
    }

    static int N, M, K;
    static ArrayList<Tree> list;
    static int[][] ground, A, die;
    static int[] dc = {0, 0, -1, 1, -1, 1, 1, -1}, dr = {-1, 1, 0, 0, -1, -1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        ground = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                ground[i][j] = 5;
            }
        }

        A = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            list.add(new Tree(r, c, a));
        }

        while(K-- > 0){
            spring();
            summer();
            fall();
            winter();
        }

        System.out.println(list.size());
    }

    static void spring(){
        die = new int[N + 1][N + 1];
        PriorityQueue<Tree> pq = new PriorityQueue<>();
        for(int i = 0; i < list.size(); i++){
            pq.offer(list.get(i));
        }

        list = new ArrayList<>();
        while(!pq.isEmpty()){
            Tree now = pq.poll();

            if(ground[now.row][now.col] >= now.age) {
                ground[now.row][now.col] -= now.age;
                list.add(new Tree(now.row, now.col, now.age + 1));
            }
            else {
                die[now.row][now.col] += now.age / 2;
            }
        }
    }

    static void summer() {
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                ground[i][j] += die[i][j];
            }
        }
    }

    static void fall(){
        Queue<Tree> q = new ArrayDeque<>();
        for(int i = 0; i < list.size(); i++){
            Tree now = list.get(i);

            if(now.age % 5 == 0) {
                for(int j = 0; j < 8; j++){
                    int nr = now.row + dr[j];
                    int nc = now.col + dc[j];

                    if(nr <= 0 || nc <= 0 || nr > N || nc > N) continue;

                    q.add(new Tree(nr, nc, 1));
                }
            }
        }

        while(!q.isEmpty()){
            list.add(q.poll());
        }
    }

    static void winter(){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                ground[i][j] += A[i][j];
            }
        }
    }
}
