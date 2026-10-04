import java.util.*;

class Solution {
    public int solution(String s) {
        int count = 0;
        
        for(int i=0; i<s.length(); i++){
            s = s.substring(1, s.length()) + s.substring(0,1);
            if(check(s)) count ++;
        }
        
        return count;
    }
    
    boolean check(String s){
        Stack<Character > stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c); continue;
            }
            if(stack.isEmpty()) return false;
            if(c == ')' && stack.pop() == '(') continue;
            if(c == ']' && stack.pop() == '[') continue;
            if(c == '}' && stack.pop() == '{') continue;
            else return false;
        }
        return stack.isEmpty();
    }
}