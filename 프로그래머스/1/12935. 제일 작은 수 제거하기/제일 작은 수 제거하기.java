class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1) {
            return new int[]{-1};
        } else{
            int least_num = arr[0];
            int[] answer = new int[arr.length - 1];
            
            for(int num : arr){
                if(least_num > num) least_num = num;
            }
            
            int index = 0;
            for(int num : arr){
                if(num != least_num) answer[index++] = num;
            }
            
            return answer;
        }
    }
}