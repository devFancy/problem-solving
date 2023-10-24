import java.util.*;

class Solution {
    
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static int[] lever = new int[2];
    
    public int solution(String[] maps) {
        int answer = 0;
        
        // 탐색을 위한 2차원 배열과 방문 배열 초기화
        String[][] map = new String[maps.length][maps[0].length()];
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        int[] start = new int[2];
		
        // 2차원 배열을 만들며 최초 시작 위치 탐색
        for(int i = 0; i < maps.length; i++) {
            String[] temp = maps[i].split("");
            map[i] = temp;
            for(int j = 0; j < temp.length; j++) {
                if(temp[j].equals("S")) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        
         // 레버까지 BFS 탐색
        int first = bfs(map, visited, start, "L");
        if(first == -1) {
            return -1;
        }
        
         // 탈출지점까지 BFS 탐색
        visited = new boolean[maps.length][maps[0].length()];
        int second = bfs(map, visited, lever, "E");
        if(second == -1) {
            return -1;
        }
        
         answer = first + second;
        return answer;
    }
    
    public int bfs(String[][] map, boolean[][] visited, int[] start, String target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0}); // 현재 행, 현재 열, 이동 횟수
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int currentRow = temp[0];
            int currentCol = temp[1];
            int cnt = temp[2];

            for(int i = 0; i < 4; i++) {
                int newRow = currentRow + dRow[i];
                int newCol = currentCol + dCol[i];
                if(newRow >= 0 && newRow < map.length && newCol >= 0 && newCol < map[0].length) {
                    if(map[newRow][newCol].equals(target)) {
                        lever[0] = newRow;
                        lever[1] = newCol;
                        return cnt + 1;
                    }
                    if(!map[newRow][newCol].equals("X") && !visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;
                        queue.add(new int[]{newRow, newCol, cnt + 1});
                    }
                }
            }
        }
        return -1;
    }
}