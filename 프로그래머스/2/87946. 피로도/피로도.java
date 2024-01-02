import java.util.*;

class Solution {
    static boolean[] visited;
    static int count = 0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        dfs(0, k, dungeons);
        
        return count;
    }
    private void dfs(int depth, int k, int[][] dungeons) {
        for(int i = 0; i < dungeons.length; i++) {
            // 방문하지 않은 상태이면서 k가 최소 필요 피로도보다 크거나 같은경우
            if(!visited[i] && k >= dungeons[i][0] ) {
                visited[i] = true; // 방문 처리
                dfs(depth + 1, k - dungeons[i][1], dungeons);
                visited[i] = false; // 방문 초기화
            }
        }
        count = Math.max(count, depth);
    }
}