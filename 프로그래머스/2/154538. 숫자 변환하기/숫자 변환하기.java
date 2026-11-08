import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        if (x == y) return 0;
        
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[y + 1];
        
        q.offer(new int[]{x, 0});
        visited[x] = true;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int val = curr[0];
            int count = curr[1];
            
            int[] nextVals = {val + n, val * 2, val * 3};
            
            for (int next : nextVals) {
                if (next == y) return count + 1;
                
                if (next < y && !visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, count + 1});
                }
            }
        }
        
        return -1;
    }
}