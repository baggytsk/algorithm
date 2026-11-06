import java.util.*;
class Solution {
    public int solution(int[] order) {
        Deque<Integer> stack = new ArrayDeque<>();
        int answer = 0;
        int index = 0;
        
        for (int num = 1; num <= order.length; num++) {
            if (order[index] == num) {
                answer++;
                index++;
            } else {
                stack.push(num);
            }
            
            while (!stack.isEmpty() && stack.peek() == order[index]) {
                stack.pop();
                answer++;
                index++;
            }
        }
        
        return answer;
    }
}