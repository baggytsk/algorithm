import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i=0; i<progresses.length; i++){
            q.offer((100 - progresses[i] + speeds[i] - 1) / speeds[i]);
        }
        
        List<Integer> list = new ArrayList<>();
        
        while(!q.isEmpty()){
            int cur = q.poll();
            int count = 1;
            while(!q.isEmpty()) {
                if(cur < q.peek()) break;
                q.poll(); count++; 
            }
            list.add(count);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}