class Solution {
    public int solution(int[][] sizes) {
        int walet_size = 0;
        
        int max_row = 0;
        int max_col = 0;
        
        for(int i = 0; i < sizes.length; i++) {
            int tmp;
            
            if(sizes[i][0] < sizes[i][1]) {
                tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
            
            if(max_row < sizes[i][0]) {
                max_row = sizes[i][0];
            }
            if(max_col < sizes[i][1]) {
                max_col = sizes[i][1];
            }
        }
        walet_size = max_row * max_col;
        return walet_size;
    }
}