import java.util.*;

class Solution {

    static int N;

    public int solution(String[][] book_time) {
        N = book_time.length;

        int[][] time = new int[N][2];

        for (int i = 0; i < N; i++) {
            time[i][0] = change(book_time[i][0]);    
            time[i][1] = change(book_time[i][1]) + 10;
        }

        Arrays.sort(time, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int start = time[i][0];
            int end = time[i][1];

            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }

            pq.add(end);
        }

        return pq.size();
    }

    static int change(String s) {
        int hour = Integer.parseInt(s.substring(0, 2));
        int minute = Integer.parseInt(s.substring(3, 5));

        return hour * 60 + minute;
    }
}