class Solution {
    public int[] solution(int brown, int yellow) {
        int x = 3, y = 3;
        
        
        while(true){
            boolean check = false;
            for(y=3; y<=x; y++){
                if((x+y)*2 - 4 == brown && (x-2) * (y-2) == yellow) {
                    check = true;
                    break;
                }
            }
            if(check) break;
            x++;
        }
        
        return new int[]{x, y};
    }
}