// [시간복잡도] N <= 10000 -> O(N)
// [자료구조] 최단 시간
// [풀이] 큐 -> while 뭐가 빌때? 다리 건너는 트럭이 빌때 끝 -> 어떤 값? 인덱스 or 값 or 남은 거리 -> 
// [테스트] 
// 1) 1, 1, [1]
// 2) 

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        int cur_weight = truck_weights[0];
        int next_truck = 1;
        int finish_truck = 0;
        int time = 1;
        
        while(!q.isEmpty()){
            // 전부 앞으로 가기
            int size = q.size();              
            for (int i = 0; i < size; i++) {
                if(q.peek() >= bridge_length) {
                    q.poll();
                    cur_weight -= truck_weights[finish_truck++];
                }
                else q.offer(q.poll()+1);
            }
            
            if(next_truck < truck_weights.length && weight >= cur_weight + truck_weights[next_truck]) { // 새로운 트럭 다리 건너게 하기
                q.offer(1);
                cur_weight += truck_weights[next_truck];
                next_truck++;
            }
            
            time++;
        }
        
        return time;
    }
}