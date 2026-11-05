class Solution {
    public int solution(int n, int k) {
        String num = Integer.toString(n, k);
        int answer = 0;
        
        for (String s : num.split("0")) {
            if (s.equals("")) continue;
            long p = Long.parseLong(s);
            if (p == 1) continue;
            
            boolean isPrime = true;
            for (long i = 2; i * i <= p; i++) {
                if (p % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            
            if (isPrime) answer++;
        }
        return answer;
    }
}