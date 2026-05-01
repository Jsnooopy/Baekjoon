import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;;
        
        List<List<Integer>> list = new ArrayList<>();
        
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < wires.length; i++) {
            int left = wires[i][0];
            int right = wires[i][1];
            
            list.get(left).add(right);
            list.get(right).add(left);
        }
        
        for (int i = 0; i < wires.length; i++) {
            int left = wires[i][0];
            int right = wires[i][1];
            
            list.get(left).remove(Integer.valueOf(right));
            list.get(right).remove(Integer.valueOf(left));

            int a = connection(list, left);
            int diff = (int) Math.abs(2 * a - n);
            
            answer = Math.min(answer, diff);
            
            list.get(left).add(right);
            list.get(right).add(left);            
        }
        
        return answer;
    }
    
    int connection(List<List<Integer>> list, int index) {

        boolean[] isVisited = new boolean[list.size()];
        
        Stack<List<Integer>> stack = new Stack<>();
        stack.push(list.get(index));
        isVisited[index] = true;
        int count = 1;
        
        while (!stack.isEmpty()) {
            List<Integer> li = stack.pop();
            
            for (Integer i : li) {
                if (!isVisited[i]) {
                    stack.push(list.get(i));
                    isVisited[i] = true;
                    count++;
                }
            }
        }
        
        return count;
    }
}