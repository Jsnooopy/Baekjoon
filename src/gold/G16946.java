package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class G16946 {
    static int N, M;
    static int[][] arr, group, result;
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
    static Map<Integer, Integer> groupSize = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];
        group = new int[N][M];
        result = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        // 0 Grouping
        int groupId = 1;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0 && group[i][j] == 0) {
                    int size = bfs(j, i, groupId);
                    groupSize.put(groupId, size);
                    groupId++;
                }
            }
        }

        // 벽일 때 주변 GroupSize 합산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    HashSet<Integer> set = new HashSet<>();
                    int sum = 1;
                    
                    for (int d = 0; d < 4; d++) {
                        int nx = j + dx[d];
                        int ny = i + dy[d];
                        
                        if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                        
                        int gid = group[ny][nx];
                        if (gid > 0 && !set.contains(gid)) {
                            sum += groupSize.get(gid);
                            set.add(gid);
                        }
                    }
                    
                    result[i][j] = sum % 10;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(result[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    } // main

    static int bfs(int x, int y, int id) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        group[y][x] = id;
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int xx = now[0], yy = now[1];
            
            for (int d = 0; d < 4; d++) {
                int nx = xx + dx[d];
                int ny = yy + dy[d];
                
                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                
                if (arr[ny][nx] == 0 && group[ny][nx] == 0) {
                    group[ny][nx] = id;
                    cnt++;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        
        return cnt;
    } // bfs
    
}// class
