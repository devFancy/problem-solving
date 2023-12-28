import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int[] totalQueue = new int[queue1.length + queue2.length];
        long queue1Sum = 0;
        long queue2Sum = 0;

        for(int i = 0; i < queue1.length; i++) {
            int val = queue1[i];
            totalQueue[i] = val;
            queue1Sum += val;    
        }

        for(int i = queue1.length; i < queue1.length + queue2.length; i++) {
            int val = queue2[i - queue1.length];
            totalQueue[i] = val;
            queue2Sum += val;    
        }

        if((queue1Sum + queue2Sum) % 2 == 1) return -1;

        int count = 0;
        int left = 0;
        int right = queue1.length;
        long half = (queue1Sum + queue2Sum) / 2;
        while(left < right && right < totalQueue.length) {
            if(queue1Sum == half) {
                return count;
            } else if(queue1Sum > half) {
                queue1Sum -= totalQueue[left++];
            } else {
                queue1Sum += totalQueue[right++];
            }
            count++;
        }
        return -1;
    }
}
