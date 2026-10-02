import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] strings = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            strings[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(strings, (a,b) -> (b+a).compareTo(a+b));
        if (strings[0].equals("0")) return "0"; 
        return String.join("", strings);
    }
}