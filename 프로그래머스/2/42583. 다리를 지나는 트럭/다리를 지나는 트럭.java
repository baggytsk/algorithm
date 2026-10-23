// [시간복잡도] 트럭 N ≤ 1만, 다리 길이 L ≤ 1만 → 맨 앞 트럭만 보면 되게 만들자. 트럭마다 들어가고 나가기 1번씩 = O(N) (매초 다리 전체를 움직이면 O(시간 × L) → 최악 1억 이상, 위험)
// [자료구조] 큐(Deque<int[]>) — {트럭 무게, 다리에 들어간 시각}
// [풀이] 큐 -> while 뭐가 빌때? 다리 건너는 트럭이 빌때 끝 -> 어떤 값? 인덱스 or 값 or 남은 거리 -> 무게랑 들어간 시각으로 확인
// [테스트] 
// 1) 1, 1, [1]  → 2
// 2) 1, 100, [1,1,1] → 4

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<int[]> bridge = new ArrayDeque<>(); // {무게, 진입 시각}
        int time = 0;
        int curWeight = 0;
        int next = 0; 
        
        while(next < truck_weights.length){
            time++;
            
            // ① 맨 앞 트럭이 다 건넜으면 내리기
            if (!bridge.isEmpty() && time - bridge.peek()[1] == bridge_length){
                curWeight -= bridge.poll()[0];
            }
            
            // ② 다음 트럭 올리기
            if (curWeight + truck_weights[next] <= weight) {
                bridge.offer(new int[]{truck_weights[next], time});
                curWeight += truck_weights[next];
                next++;
            }
        }
        
        return time + bridge_length;
    }
}