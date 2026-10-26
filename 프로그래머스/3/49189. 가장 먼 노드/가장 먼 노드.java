// [시간복잡도] N < 20000
// [자료구조] 인접리스트, 양방향
// [문제풀이] 

import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        
        for(int[] e : edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        boolean[] visited = new boolean[n+1];
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1, 0});
        visited[1] = true;
        int cnt = 0, depth = 0;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(depth < cur[1]){
                depth = cur[1]; cnt = 0;
            }
            cnt++;
            
            for(int next : graph.get(cur[0])){
                if(visited[next]) continue;
                visited[next] = true;
                q.offer(new int[]{next, cur[1]+1});
            }
        }
        
        return cnt;
    }
}