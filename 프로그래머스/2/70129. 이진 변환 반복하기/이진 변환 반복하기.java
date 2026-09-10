class Solution {
    public int[] solution(String s) {
        String newString = s;
        int changeCount = 1;
        int removeCount = 0;
        
        while(!newString.equals("1")){
            int len = newString.length();
            newString = newString.replaceAll("0", "");
            int c = newString.length();
            removeCount += len-c;
            if(newString.equals("1")) break;
            
            StringBuilder sb = new StringBuilder();
            while(c != 1){
                sb.insert(0, c%2);
                c/=2;
                if(c==1) sb.insert(0, 1);
            }
            
            newString = sb.toString();
            changeCount++;
        }
        
        return new int[]{changeCount, removeCount};
    }
}