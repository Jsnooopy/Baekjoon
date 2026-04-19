import java.util.*;

class Solution {
    int length = 0;
    boolean[] visited;
    ArrayList<String> list;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        length = tickets.length;
        
        visited = new boolean[length];
        list = new ArrayList<>();
        
        dfs("ICN", "ICN", tickets, 0);
        
        Collections.sort(list);
        answer = list.get(0).split(" ");
        
        return answer;
    }
    public void dfs(String start, String route, String[][] tickets, int count){
        if (count==length){
            list.add(route);
            return;
        }
        for (int i = 0; i<length; i++){
            if(!visited[i] && start.equals(tickets[i][0])){
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, count+1);
                visited[i] = false;
            }
        }
    }
}