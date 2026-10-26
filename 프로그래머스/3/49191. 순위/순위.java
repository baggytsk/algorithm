// [시간복잡도] N<100, E<4500
// [자료구조]
// [풀이] 플로이드-워셜

class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] win = new boolean[n + 1][n + 1];
        for (int[] r : results) {
            win[r[0]][r[1]] = true;
        }
        
        for (int k = 1; k <= n; k++){
            for (int a = 1; a <= n; a++){
                for (int b = 1; b <= n; b++){
                    if(win[a][k] && win[k][b]) win[a][b] = true;
                }
            }
        }
            
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if(win[i][j] || win[j][i]) cnt++;
            }
            if(cnt == n-1) answer++;
        }
        
        return answer;
    }
}