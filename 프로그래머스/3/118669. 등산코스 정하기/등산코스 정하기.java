import java.util.*;

class Solution {

    static class Node implements Comparable<Node> {
        int num, cost;

        Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int N;
    static ArrayList<Node>[] list;
    static int[] distance;
    static boolean[] isSummit;
    static final int INF = Integer.MAX_VALUE;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        N = n;
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int[] path : paths) {
            int a = path[0];
            int b = path[1];
            int c = path[2];
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        isSummit = new boolean[N + 1];
        for (int summit : summits) isSummit[summit] = true;

        distance = new int[N + 1];
        Arrays.fill(distance, INF);

        dijkstra(gates);

        Arrays.sort(summits);
        int summitNum = 0;
        int intensity = INF;

        for (int summit : summits) {
            if (distance[summit] < intensity) {
                intensity = distance[summit];
                summitNum = summit;
            }
        }

        return new int[]{summitNum, intensity};
    }

    static void dijkstra(int[] gates) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int gate : gates) {
            distance[gate] = 0;
            pq.offer(new Node(gate, 0));
        }

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (distance[now.num] < now.cost) continue;
            if (isSummit[now.num]) continue;

            for (Node next : list[now.num]) {
                int nextCost = Math.max(distance[now.num], next.cost);

                if (distance[next.num] <= nextCost) continue;

                distance[next.num] = nextCost;
                pq.offer(new Node(next.num, nextCost));
            }
        }
    }
}