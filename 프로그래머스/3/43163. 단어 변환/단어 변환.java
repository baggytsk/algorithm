import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<String> q = new ArrayDeque<>();
        q.offer(begin);
        int step = 0;
        
        while(!q.isEmpty()){
            int size = q.size();               
            
            for (int s = 0; s < size; s++) {
                String cur = q.poll();
                if (cur.equals(target)) return step;
                for (int i = 0; i < words.length; i++) {
                    if (!visited[i] && canChange(cur, words[i])) {
                        visited[i] = true;
                        q.offer(words[i]);
                    }
                }
            }
            
            step++;
        }
        
        return 0;
    }
    
    boolean canChange(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++)
            if (a.charAt(i) != b.charAt(i)) diff++;
        return diff == 1;
    }
}