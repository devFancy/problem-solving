class Solution {
    static int brown_row;
    static int brown_col;
    public int[] solution(int brown, int yellow) {
        
        Carpet(brown, yellow);
        
        int answer[] = new int[2];
        answer[0] = brown_row;
        answer[1] = brown_col;
        return answer;
    }
    
    static void Carpet(int brown, int yellow) {
        
        for(int i = 1; i <= yellow; i++) {
            int yellow_row = yellow/i;
            int yellow_col = i;
            brown_row = 0;
            brown_col = 0;
            
            if(yellow_row >= yellow_col) {
                if(yellow % yellow_row > 0) {
                    yellow_col++;
                }
                brown_row = yellow_row + 2;
                brown_col = yellow_col + 2;
            
                if((brown_row * brown_col) == (brown + yellow)) {
                    return;
                }
            }
            else {
                return;
            }
            
        }
    }
}