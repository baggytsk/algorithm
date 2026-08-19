import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Integer> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(c == '(') stack.push(1);
            else if(c == ')') {
                if(stack.empty()) return false;
                stack.pop();
            }
        }

        return stack.empty() ? true : false;
    }
}