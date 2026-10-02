import java.util.*;

class Solution {
    
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] maps) {
        int n = maps.length, m = maps[0].length;
        int[][] dist = new int[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        dist[0][0] = 1;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int d=0; d<4; d++){
                int nx = cur[0]+dx[d], ny = cur[1]+dy[d];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (maps[nx][ny] == 0 || dist[nx][ny] != 0) continue;
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
        
        return dist[n - 1][m - 1] == 0 ? -1 : dist[n - 1][m - 1];
    }
}