import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, T;
    static int[][] board;
    static boolean[][] delete;
    static int[] dj = {0, 0, -1, 1}, di = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        board = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for(int i = 1; i <= N; i++) {
                if (i % x == 0) {
                    rotate(i, d, k);
                }
            }
            if(check()) near();
        }

        System.out.println(count());
    }

    // 회전
    static void rotate(int x, int d, int k) {
        if(d == 0){
            clockwise(x, k);
        } else{
            counterClockwise(x, k);
        }
    }

    // 시계 회전
    static void clockwise(int x, int k){
        for(int i = 0; i < k; i++){
            for(int j = M; j > 0; j--){
                if(j == M) board[x][0] = board[x][j];
                else board[x][j + 1] = board[x][j];
            }
            board[x][1] = board[x][0];
        }
    }

    // 반시계 회전
    static void counterClockwise(int x, int k){
        for(int i = 0; i < k; i++){
            for(int j = 1; j <= M; j++){
                if(j == 1) board[x][0] = board[x][1];
                else board[x][j - 1] = board[x][j];
            }
            board[x][M] = board[x][0];
        }
    }

    // 원판에 수 남은 여부
    static boolean check(){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(board[i][j] != 0) return true;
            }
        }
        return false;
    }

    // 인접 수 처리
    static void near(){
        delete = new boolean[N + 1][M + 1];

        boolean flag = false;
        for(int i = 1; i <= N; i++){
            for (int j = 1; j <= M; j++) {
                if(board[i][j] == 0) continue;

                for(int k = 0; k < 4; k++){
                    int ni = i + di[k];
                    int nj = j + dj[k];

                    if(ni <= 0 || ni > N) continue;

                    if(j == 1){
                        if(nj == 0) nj = M;
                        if(board[i][j] == board[ni][nj]) {
                            delete[i][j] = true;
                            delete[ni][nj] = true;
                            flag = true;
                        }
                    } else if (j == M) {
                        if(nj == M + 1) nj = 1;
                        if(board[i][j] == board[ni][nj]) {
                            delete[i][j] = true;
                            delete[ni][nj] = true;
                            flag = true;
                        }
                    } else {
                        if(board[i][j] == board[ni][nj]) {
                            delete[i][j] = true;
                            delete[ni][nj] = true;
                            flag = true;
                        }
                    }
                }
            }
        }

        if(flag) remove();
        else avg();
    }

    // 인접 수 삭제
    static void remove(){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(delete[i][j]) board[i][j] = 0;
            }
        }
    }

    // 총 평균 구한 후 감가
    static void avg(){
        int sum = 0;
        int cnt = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(board[i][j] != 0){
                    sum += board[i][j];
                    cnt++;
                }
            }
        }

        double avg = (double) sum / cnt;

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(board[i][j] == 0) continue;

                if(board[i][j] > avg) board[i][j] -= 1;
                else if(board[i][j] < avg) board[i][j] += 1;
            }
        }
    }

    // 원판에 적힌 수 합
    static int count(){
        int sum = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(board[i][j] != 0){
                    sum += board[i][j];
                }
            }
        }

        return sum;
    }
}
