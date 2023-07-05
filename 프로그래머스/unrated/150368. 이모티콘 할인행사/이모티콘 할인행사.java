import java.util.*;

public class Solution {
    int[] answer;
    int[] usersDiscount, usersPrice;
    int[] emoticonsPrice;
    int[] discountArray;

    public int[] solution(int[][] users, int[] emoticons) {
        int userLength = users.length;
        int emoticonLength = emoticons.length;

        usersDiscount = new int[userLength];
        usersPrice = new int[userLength];

        for (int i = 0; i < userLength; i++) {
            usersDiscount[i] = users[i][0];
            usersPrice[i] = users[i][1];
        }

        emoticonsPrice = Arrays.copyOf(emoticons, emoticonLength);
        discountArray = new int[]{10, 20, 30, 40};

        answer = new int[2];

        dfs(0, new int[emoticonLength]);

        return answer;
    }

    private void dfs(int depth, int[] discounts) {
        if (depth == discounts.length) {
            int[] tmpResult = new int[2];

            for (int i = 0; i < usersDiscount.length; i++) {
                int tmpPrice = 0;

                for (int j = 0; j < discounts.length; j++) {
                    if (discounts[j] >= usersDiscount[i]) {
                        tmpPrice += emoticonsPrice[j] * (100 - discounts[j]) / 100;
                    }
                }

                if (tmpPrice >= usersPrice[i]) {
                    tmpResult[0]++;
                } else {
                    tmpResult[1] += tmpPrice;
                }
            }

            if (answer[0] < tmpResult[0] || (answer[0] == tmpResult[0] && answer[1] < tmpResult[1])) {
                answer = Arrays.copyOf(tmpResult, 2);
            }

            return;
        }

        for (int i = 0; i < 4; i++) {
            discounts[depth] = discountArray[i];
            dfs(depth + 1, discounts);
        }
    }
}
