class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;
        
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        
        for (int i = 0; i < 4; i++) {
            int nextH = h + dh[i];
            int nextW = w + dw[i];
            
            if (nextH >= 0 && nextH < n && nextW >= 0 && nextW < n) {
                if (board[h][w].equals(board[nextH][nextW])) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}