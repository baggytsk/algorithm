import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int w : works) {
            pq.offer(w);
        }
        
        while (n > 0) {
            int max = pq.poll();
            if (max == 0) break;
            pq.offer(max - 1);
            n--;
        }
        
        while (!pq.isEmpty()) {
            long w = pq.poll();
            answer += w * w;
        }
        
        return answer;
    }
}