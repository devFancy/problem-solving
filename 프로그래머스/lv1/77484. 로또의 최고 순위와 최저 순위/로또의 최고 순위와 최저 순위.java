import java.util.*;

public class Solution {

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        Map<Integer, Integer> compareRank = init();

        int zero_count = 0, same_number = 0;

        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0) {
                zero_count += 1;
                continue;
            }
            for (int j = 0; j < 6; j++) {
                if (lottos[i] == win_nums[j]) {
                    same_number += 1;
                    break;
                }
            }
        }

        answer[0] = compareRank.get(same_number + zero_count);
        answer[1] = compareRank.get(same_number);

        return answer;
    }

    private Map<Integer, Integer> init() {
        Map<Integer, Integer> ret = new HashMap<>();
        int rank = 6;
        for (int i = 0; i <= 6; i++) {
            if (i == 0 || i == 1) {
                ret.put(i, rank);
                continue;
            }
            rank -= 1;
            ret.put(i, rank);
        }
        return ret;
    }
}