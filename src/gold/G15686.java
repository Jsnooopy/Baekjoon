package gold;

import java.io.*;
import java.util.*;

public class G15686 {

    static int N, M;
    static int[][] map;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static boolean[] selected;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) houses.add(new int[]{i, j});
                else if (map[i][j] == 2) chickens.add(new int[]{i, j});
            }
        }

        selected = new boolean[chickens.size()];
        combination(0, 0);

        System.out.println(result);
    } // main

    static void combination(int idx, int cnt) {
        if (cnt == M) {
            result = Math.min(result, calc());
            return;
        }
        
        if (idx == chickens.size()) return;

        selected[idx] = true;
        combination(idx + 1, cnt + 1);

        selected[idx] = false;
        combination(idx + 1, cnt);
    } // combination

    static int calc() {
        int sum = 0;
        
        for (int[] h : houses) {
            int hy = h[0], hx = h[1];
            int distance = Integer.MAX_VALUE;
            
            for (int i = 0; i < chickens.size(); i++) {
                if (selected[i]) {
                    int[] c = chickens.get(i);
                    int cy = c[0], cx = c[1];
                    distance = Math.min(distance, Math.abs(hy - cy) + Math.abs(hx - cx));
                }
            }

            sum += distance;
        }
        
        return sum;
    } // calc
    
} // class