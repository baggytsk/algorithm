// [시간복잡도] N <= 10^5 -> O(N) 필요
// [자료구조] “처음으로 나보다 작아지는 시점” = 단조 스택
// [풀이 후보] 스택에 넣고 하나씩 뒤로 이동 각각보다 떨어지지 않으면 +1 -> 틀림
// [최종 풀이] 풀이 아이디어 보고 풀어봄 -> 스택 만들어서 
// 0 -> stack 0
// 1 -> stack 0 1
// 2 -> stack 0 1 2
// 3 -> 2 꺼내져서 answer[2] = 1 / stack 0 1 3
// 4 -> stack 0 1 3 4


import java.util.ArrayDeque;
import java.util.Deque;
class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        // Stack<Integer> stack = new Stack<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<len; i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = len - 1 - idx;
        }
        
        return answer;
    }
}


// [테스트] [1, 2, 3, 1, 3] -> [4, 2, 1, 1, 0]
// 0 -> stack 0
// 1 -> stack 0 1
// 2 -> stack 0 1 2
// 3 -> 2 꺼내져서 answer[2] = 1  / 1 꺼내져서 answer[1] = 2 / stack 0 3
// 4 -> stack 0 3 4

// [테스트]
// 1.최소	[1, 2] -> [1, 0]
// 2.모두 같은 값 [3, 3, 3] -> [2, 1, 0]
// 3.계속 떨어짐	[5, 4, 3] -> [1, 1, 0]