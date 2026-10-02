import java.util.*;

class Solution {
    int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    
    public int solution(int[][] game_board, int[][] table) {
        List<List<int[]>> blanks = extract(game_board, 0);
        List<List<int[]>> pieces = extract(table, 1);
        boolean[] usedPiece = new boolean[pieces.size()];
        int answer = 0;

        for (List<int[]> blank : blanks) {
            for (int i = 0; i < pieces.size(); i++) {
                if (usedPiece[i] || pieces.get(i).size() != blank.size()) continue;
                if (matches(blank, pieces.get(i))) {
                    usedPiece[i] = true;
                    answer += blank.size();
                    break;
                }
            }
        }
        return answer;
    }
    
    List<List<int[]>> extract(int[][] b, int t){
        List<List<int[]>> result = new ArrayList<>();
        int n = b.length;
        boolean[][] visited = new boolean[n][n];
        
        for(int x=0; x<n; x++){
            for(int y=0; y<n; y++){
                if(visited[x][y] || b[x][y] != t) continue;
                List<int[]> shape = new ArrayList<>();
                visited[x][y] = true;
                Queue<int[]> q = new ArrayDeque<>();
                q.offer(new int[]{x,y});
                
                while(!q.isEmpty()){
                    int[] cur = q.poll();
                    shape.add(cur);
                    for(int d=0; d<4; d++){
                        int nx = cur[0] + dx[d], ny = cur[1] + dy[d];
                        if(nx < 0 || nx >= n || ny < 0 || ny >= n || b[nx][ny] != t || visited[nx][ny]) continue;
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
                result.add(normalize(shape));
            }
        }
        return result;
    }
    
    List<int[]> normalize(List<int[]> s){
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        for(int[] p : s) {
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);
        }
        List<int[]> result = new ArrayList<>();
        for (int[] p : s) result.add(new int[]{p[0] - minX, p[1] - minY});
        result.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        return result;
    }
    
    List<int[]> rotate(List<int[]> shape) {
        List<int[]> result = new ArrayList<>();
        for (int[] p : shape) result.add(new int[]{p[1], -p[0]});
        return normalize(result);
    }
    
    boolean matches(List<int[]> blank, List<int[]> piece) {
        for (int r = 0; r < 4; r++) {
            boolean same = true;
            for (int k = 0; k < blank.size(); k++) {
                if (blank.get(k)[0] != piece.get(k)[0] || blank.get(k)[1] != piece.get(k)[1]) {
                    same = false;
                    break;
                }
            }
            if (same) return true;
            piece = rotate(piece);
        }
        return false;
    }
    
}