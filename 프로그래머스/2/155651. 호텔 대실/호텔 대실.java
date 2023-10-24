import java.util.*;


class Solution {
    public int solution(String[][] book_time) {
        int answer = 1;
        int[] timeCheck = new int[24*60+10];
 
        for (int i=0; i<book_time.length; i++) {
            int start = convertTime(book_time[i][0].split(":"));
            int end = convertTime(book_time[i][1].split(":"));      
            timeCheck[start] += 1;
            timeCheck[end+10] -= 1;
        } 
        for (int i=1; i<timeCheck.length; i++) {
            timeCheck[i] += timeCheck[i-1];
            if (answer < timeCheck[i]) {
                answer = timeCheck[i];
            }
        }
        return answer;
    }
    
    public int convertTime(String[] time) {
        int hour = Integer.parseInt(time[0]);
        int min = Integer.parseInt(time[1]);
        return (hour * 60) + min;
    }
}