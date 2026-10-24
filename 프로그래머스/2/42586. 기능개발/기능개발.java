// [시간] N < 100 -> O(N^2) 가능
// [자료구조] 큐
// [풀이] 남은 시간 넣어두고 계속 빼기

import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();
        
        for(int i=0; i<progresses.length; i++){
            int lastTime = (100 - progresses[i])/speeds[i];
            if((100 - progresses[i])%speeds[i] != 0) lastTime++;
            q.offer(lastTime);
        }
        
        while(!q.isEmpty()){
            int time = q.poll();
            int count = 1;
            
            while(!q.isEmpty() && q.peek() <= time){
                q.poll();
                count++;
            }
            
            answer.add(count);
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}