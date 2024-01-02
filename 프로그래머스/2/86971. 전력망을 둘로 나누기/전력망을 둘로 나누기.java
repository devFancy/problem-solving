import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static int min;

    public int solution(int n, int[][] wires) {
        
        // 0. 입력 및 초기화
        min = Integer.MAX_VALUE;
        graph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 1. 연결 정보 채우기
        for(int i = 0; i < wires.length; i++) {
            int x = wires[i][0];
            int y = wires[i][1];
            graph[x].add(y);
            graph[y].add(x);
        }
        
        for(int i = 0; i < wires.length; i++) {
            int x = wires[i][0];
            int y = wires[i][1];
            
            boolean[] visited = new boolean[n + 1];
            graph[x].remove(Integer.valueOf(y));
            graph[y].remove(Integer.valueOf(x));
            
            // 2. dfs(재귀 함수) 호출하기
            int cnt = dfs(1, visited);
            
            int diff = Math.abs(cnt - (n - cnt));
            min = Math.min(min, diff);
            
            graph[x].add(y);
            graph[y].add(x);
        }
        // 3. 출력
        return min;
    }
    public static int dfs(int idx, boolean[] visited) {
        visited[idx] = true;
        int cnt = 1;
 
        for (int next : graph[idx]) {
            if (!visited[next]) {
                cnt += dfs(next, visited);
            }
        }
 
        return cnt;
    }
}