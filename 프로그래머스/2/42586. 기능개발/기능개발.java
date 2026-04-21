import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i = 0; i < progresses.length; i++){
            int remain = 100 - progresses[i];
            int finish = remain / speeds[i];
            
            if(remain % speeds[i] != 0) finish++;
            
            q.offer(finish);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        while(!q.isEmpty()){
            int day = q.poll();
            int count = 1;
            
            while(!q.isEmpty() && q.peek() <= day){
                q.poll();
                count++;
            }
            
            list.add(count);
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}