import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int i = 0;
        
        for(int[] c : commands){
            int[] temp = Arrays.copyOfRange(array, c[0]-1, c[1]);
            Arrays.sort(temp);
            answer[i] = temp[c[2]-1];
            i++;
        }
        
        return answer;
    }
}