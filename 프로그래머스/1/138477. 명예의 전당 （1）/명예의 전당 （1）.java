import java.util.ArrayList;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<score.length; i++){
            if(list.size() < k) {
                list.add(score[i]);
                list.sort(null);
            } else{
                if(score[i] > list.get(0)){
                    list.remove(0);
                    list.add(score[i]);
                    list.sort(null);
                }
            }
            answer[i] = list.get(0);
        }
        
        return answer;
    }
}