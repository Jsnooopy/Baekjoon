class Solution {
    static int[] numbers;
    static int target, answer;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        dfs(0, 0);
        
        return answer;
    }
    
    static void dfs(int depth, int num){
        if(depth == numbers.length){
            if(num == target) answer++;
            return;
        }
        
        num += numbers[depth];
        dfs(depth + 1, num);
        num -= numbers[depth];
        
        num -= numbers[depth];
        dfs(depth + 1, num);
        num += numbers[depth];
        
        return;
    }
}