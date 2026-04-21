import java.util.*;

class Solution {
    
    static class Process {
        int idx, priority;
        
        Process(int idx, int priority){
            this.idx = idx;
            this.priority = priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        Queue<Process> q = new ArrayDeque<>();
        
        for(int i = 0; i < priorities.length; i++){
            q.offer(new Process(i, priorities[i]));
        }
        
        int answer = 0;
        
        while(!q.isEmpty()){
            Process now = q.poll();
            boolean check = false;
            
            for(Process next : q){
                if(next.priority > now.priority){
                    check = true;
                    break;
                }
            }
            
            if(check){
                q.offer(now);
            }else{
                answer++;
                
                if(now.idx == location) break;
            }
        }
        
        return answer;
    }
}