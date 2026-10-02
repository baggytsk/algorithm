import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[102][102];
        for(int[] r : rectangle){
            int x1 = r[0] * 2, y1 = r[1] * 2, x2 = r[2] * 2, y2 = r[3] * 2;
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    if (x > x1 && x < x2 && y > y1 && y < y2) map[x][y] = 2;
                    else if (map[x][y] != 2) map[x][y] = 1;
                }
            }
        }
        
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        int[][] dist = new int[102][102];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{characterX * 2, characterY * 2});
        dist[characterX * 2][characterY * 2] = 1;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if (cur[0] == itemX * 2 && cur[1] == itemY * 2)
                return (dist[cur[0]][cur[1]] - 1) / 2;
            for(int d=0; d<4; d++){
                int nx = cur[0] + dx[d], ny = cur[1] + dy[d];
                if (map[nx][ny] != 1 || dist[nx][ny] != 0) continue;
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
        return 0;
    }
}