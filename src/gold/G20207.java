package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G20207 {

    static class Plan implements Comparable<Plan> {
        int s, e;

        public Plan(int s, int e){
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Plan p) {
            if (this.s == p.s) return p.e - this.e;
            return this.s - p.s;
        }
    }   // Plan

    static int N;
    static int[] planner;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        planner = new int[366];

        PriorityQueue<Plan> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            pq.add(new Plan(S, E));
        }

        System.out.println(area(pq));
    }   // main

    static int area(PriorityQueue<Plan> pq) {
        while (!pq.isEmpty()) {
            Plan plan = pq.poll();

            int S = plan.s;
            int E = plan.e;

            for (int i = S; i <= E; i++) {
                planner[i]++;
            }
        }

        int start = 0;
        int end = 0;
        int a = 0;
        boolean check = false;
        while (true) {
            int height = 0;

            for (int i = end + 1; i <= 365; i++) {
                if(planner[i] != 0) {
                    start = i;
                    break;
                }
                if(i == 365) check = true;
            }

            if(check) break;

            for (int i = start; i <= 365; i++) {
                if (planner[i] == 0) {
                    end = i - 1;
                    break;
                } else {
                    height = Math.max(height, planner[i]);
                }
                if(i == 365) {
                    check = true;
                    end = 365;
                }
            }

            a += (end - start + 1) * height;

            if(check) break;
        }

        return a;
    }   // area

}   // class
