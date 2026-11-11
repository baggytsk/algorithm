import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        String[] columns = {"code", "date", "maximum", "remain"};
        int extIdx = -1;
        int sortIdx = -1;
        
        for (int i = 0; i < 4; i++) {
            if (columns[i].equals(ext)) extIdx = i;
            if (columns[i].equals(sort_by)) sortIdx = i;
        }
        
        final int eIdx = extIdx;
        final int sIdx = sortIdx;
        
        List<int[]> list = new ArrayList<>();
        for (int[] row : data) {
            if (row[eIdx] < val_ext) {
                list.add(row);
            }
        }
        
        list.sort((o1, o2) -> Integer.compare(o1[sIdx], o2[sIdx]));
        
        int[][] answer = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}