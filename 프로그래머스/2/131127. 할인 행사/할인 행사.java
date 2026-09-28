import java.util.HashMap;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> count = new HashMap<>();
        for(int i=0; i<want.length; i++){
            count.put(want[i], number[i]);
        }
        
        for(int i=0; i<9; i++){
            count.put(discount[i], count.getOrDefault(discount[i], 1)-1);
        }
        
        for(int i=0; i<=discount.length-10; i++){
            count.put(discount[i+9], count.getOrDefault(discount[i+9], 1)-1);
            
            boolean check = true;
            for(String s: want){
                if(count.get(s) == 0) continue;
                else {
                    check = false;
                    break;
                }
            }
            
            if(check) answer++;
            
            count.put(discount[i], count.get(discount[i])+1);
        }
        
        return answer;
    }
}