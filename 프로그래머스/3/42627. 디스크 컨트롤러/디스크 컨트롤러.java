// [시간복잡도] O(N log N) — 정렬 + PQ 삽입/삭제 N번
// [자료구조] 요청시각 정렬 배열 + 대기 PQ(소요 → 요청 → 번호)
// [문제풀이] time까지 들어온 작업을 PQ에 넣고 가장 짧은 것부터 실행, 비면 다음 요청 시각으로 점프

import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int n = jobs.length;
        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) arr[i] = new int[]{jobs[i][0], jobs[i][1], i};
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[2], b[2]);
        });
        int idx = 0, time = 0, done = 0;
        long total = 0;
        
        while(done < n){
            while (idx < n && arr[idx][0] <= time) {
                pq.offer(arr[idx++]);
            }
            
            if (pq.isEmpty()) {
                time = arr[idx][0];
                continue;
            }
            
            int[] cur = pq.poll();
            time += cur[1];
            total += time - cur[0];
            done++;
        }
        return (int) (total / n);
    }
}