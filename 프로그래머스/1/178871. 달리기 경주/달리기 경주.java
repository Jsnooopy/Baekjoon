import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> rank = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            rank.put(players[i], i);
        }

        for (String calling : callings) {
            int now = rank.get(calling);
            String frontPlayer = players[now - 1];

            players[now - 1] = calling;
            players[now] = frontPlayer;

            rank.put(calling, now - 1);
            rank.put(frontPlayer, now);
        }

        return players;
    }
}