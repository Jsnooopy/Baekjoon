package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G1647 {

    static class Edge implements Comparable<Edge>{
        int s, e, v;

        Edge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(Edge e) {
            return this.v - e.v;
        }
    } // Edge

    static int N, M;
    static int[] parent;
    static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            pq.add(new Edge(s, e, v));
        }

        int used = 0;
        int result = 0;
        while (used < N - 1) {
            Edge edge = pq.poll();

            if (find(edge.s) != find(edge.e)) {
                union(edge.s, edge.e);
                if(used != N - 2) result += edge.v;
                used++;
            }
        }

        System.out.println(result);
    } // main

    static void union(int num1, int num2) {
        num1 = parent[num1];
        num2 = parent[num2];

        if(num1 != num2) parent[num2] = num1;
    } // union

    static int find(int num) {
        if(num == parent[num]) return num;
        else return parent[num] = find(parent[num]);
    } // find

} // class
