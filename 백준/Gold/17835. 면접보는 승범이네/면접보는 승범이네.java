import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Road implements Comparable<Road>{
        int arrive;
        long far;

        Road(int arrive, long far) {
            this.arrive = arrive;
            this.far = far;
        }

        public int compareTo(Road r) {
            return Math.toIntExact(this.far - r.far);
        }
    }

    static int N, M, K;
    static ArrayList<Road>[] list;
    static long[] distance;
    static boolean[] visited;
    static ArrayList<Integer> interview = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[s].add(new Road(e, c));
        }

        distance = new long[N + 1];
        Arrays.fill(distance, Long.MAX_VALUE);
        visited = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            interview.add(Integer.parseInt(st.nextToken()));
        }

        dijkstra();

        int city = 1;
        long far = distance[1];

        for (int i = 2; i <= N; i++) {
            if (distance[i] > far) {
                far = distance[i];
                city = i;
            }
        }

        sb.append(city).append("\n");
        sb.append(far);

        System.out.println(sb);
    }

    static void dijkstra() {
        PriorityQueue<Road> pq = new PriorityQueue<>();

        for (int start : interview) {
            distance[start] = 0;
            pq.offer(new Road(start, 0));
        }

        while (!pq.isEmpty()) {
            Road now = pq.poll();

            if(visited[now.arrive]) continue;
            visited[now.arrive] = true;

            for (Road next : list[now.arrive]) {
                if(visited[next.arrive]) continue;

                if (distance[next.arrive] > distance[now.arrive] + next.far) {
                    distance[next.arrive] = distance[now.arrive] + next.far;
                    pq.offer(new Road(next.arrive, distance[next.arrive]));
                }
            }
        }
    }
}