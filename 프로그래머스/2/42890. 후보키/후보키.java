import java.util.*;

class Solution {

    static int N, M;
    static String[][] relation;

    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> keys = new ArrayList<>();

    public int solution(String[][] relation) {
        this.relation = relation;

        N = relation.length;      
        M = relation[0].length; 

        for (int i = 1; i <= M; i++) {
            comb(0, 0, i);
        }

        return keys.size();
    }

    static void comb(int depth, int start, int target) {
        if (depth == target) {
            if (!isMinimal()) return;
            if (!isUnique()) return;

            keys.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < M; i++) {
            list.add(i);
            comb(depth + 1, i + 1, target);
            list.remove(list.size() - 1);
        }
    }

    static boolean isMinimal() {
        for (ArrayList<Integer> key : keys) {
            boolean check = true;

            for (int col : key) {
                if (!list.contains(col)) {
                    check = false;
                    break;
                }
            }

            if (check) return false;
        }

        return true;
    }

    static boolean isUnique() {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();

            for (int col : list) {
                sb.append(relation[i][col]).append("|");
            }

            set.add(sb.toString());
        }

        return set.size() == N;
    }
}