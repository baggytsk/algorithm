// [시간복잡도] N <= 100
// [자료구조] 인접리스트 
// [풀이] 

import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        
        for(int[] w : wires){
            graph.get(w[0]).add(w[1]);
            graph.get(w[1]).add(w[0]);
        }
        
        int answer = n;
        
        for(int[] w : wires){
            boolean[] visited = new boolean[n + 1];
            Deque<Integer> q = new ArrayDeque<>();
            q.offer(1);
            visited[1] = true;
            int cnt = 1;
            
            while (!q.isEmpty()) {
                int t = q.poll();
                for (int next : graph.get(t)) {
                    if((t == w[0] && next == w[1]) ||(t == w[1] && next == w[0])) continue;
                    if(visited[next]) continue;
                        
                    visited[next] = true;
                    q.offer(next);
                    cnt++;
                }
            }
            
            answer = Math.min(answer, Math.abs(n-cnt-cnt));
        }
        
        return answer;
    }
}