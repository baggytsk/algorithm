import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        makeNum("", numbers);
        int count = 0;
        for(int n : set){
            if(isPrime(n)) count++;
        }
        return count;
    }
    
    boolean isPrime(int num){
        if(num <= 1) return false;
        for(int i=2; (long) i * i <= num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
    
    void makeNum(String cur, String rest){
        if(!cur.isEmpty()) set.add(Integer.parseInt(cur));
        for(int i=0; i<rest.length(); i++){
            makeNum(cur + rest.charAt(i), rest.substring(0, i) + rest.substring(i+1));
        }
    }
}