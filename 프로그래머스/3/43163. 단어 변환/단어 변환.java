class Solution {
    
    static String target;
    static String[] words;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        this.target = target;
        this.words = words;
        visited = new boolean[words.length];
        
        dfs(0, begin);
        
        if(answer == Integer.MAX_VALUE) return 0;
        else return answer;
    }
    
    static void dfs(int depth, String s){
        if(s.equals(target)){
            answer = Math.min(answer, depth);
            return;
        }
        
        for(int j = 0; j < words.length; j++){
            int cnt = 0;
            
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) != words[j].charAt(i)) cnt++;
            }
            
            if(cnt == 1 && !visited[j]) {
                visited[j] = true;
                dfs(depth + 1, words[j]);
                visited[j] = false;
            }
        }
    }
}