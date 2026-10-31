import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        class Stage implements Comparable<Stage> {
            int idx;
            double failRate;
            
            public Stage(int idx, double failRate) {
                this.idx = idx;
                this.failRate = failRate;
            }
            
            @Override
            public int compareTo(Stage o) {
                if (this.failRate == o.failRate) {
                    return Integer.compare(this.idx, o.idx);
                }
                return Double.compare(o.failRate, this.failRate);
            }
        }
        
        int[] challenger = new int[N + 2];
        for (int s : stages) {
            challenger[s]++;
        }
        
        List<Stage> list = new ArrayList<>();
        int totalPlayers = stages.length;
        
        for (int i = 1; i <= N; i++) {
            if (challenger[i] == 0) {
                list.add(new Stage(i, 0.0));
            } else {
                double rate = (double) challenger[i] / totalPlayers;
                list.add(new Stage(i, rate));
                totalPlayers -= challenger[i];
            }
        }
        
        Collections.sort(list);
        
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = list.get(i).idx;
        }
        
        return answer;
    }
}