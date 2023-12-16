import java.util.*;
import java.io.*;
// 미로탈출
class Solution {
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static int[] lever = new int[2];

    public int bfs(String[][] map, boolean[][] visited, int[] start, String target) {
        visited[start[0]][start[1]] = true;

        Queue<int[]> queue = new LinkedList<>();
        // 현재 행, 현재 열, 이동 횟수
        queue.add(new int[]{start[0], start[1], 0}); 

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int curRow = temp[0];
            int curCol = temp[1];
            int count = temp[2];

            for(int i = 0; i < 4; i++) {
                int nextRow = curRow + dRow[i];
                int nextCol = curCol + dCol[i];
                if(nextRow >= 0 && nextRow < map.length
                && nextCol >= 0 && nextCol < map[0].length) {
                    if(map[nextRow][nextCol].equals(target)) {
                        lever[0] = nextRow;
                        lever[1] = nextCol;
                        return count + 1;
                    }
                    if(!map[nextRow][nextCol].equals("X")
                    && visited[nextRow][nextCol] == false) {
                        visited[nextRow][nextCol] = true;
                        queue.add(new int[]{nextRow, nextCol, count + 1});
                    }
                }
            }
        }
        return -1;
    }

    public int solution(String[] maps) {
        // 0. 입력 및 초기화
        int answer = 0;
        
        String[][] map = new String[maps.length][maps[0].length()];
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                visited[i][j] = false;
            }
        }
        int[] start = new int[2];

        // 1. 연결정보 채우기 - 2차원 배열을 만들며 최초 시작 위치 탐색 후 저장
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

        // 2-1. 레버까지 BFS 탐색
        int first = bfs(map, visited, start, "L");
        if(first == -1) { // 만약 레버를 발견하지 못했다면 -1을 return
            return -1;
        }

        // 2-2. 탈출 지점까지 BFS 탐색
        visited = new boolean[maps.length][maps[0].length()];
        int second = bfs(map, visited, lever, "E");

        // 3. 출력하기
        if(second == -1 ) { // 만약 탈출할 수 없다면 -1을 return
            return -1;
        }
        answer = first + second;
        return answer;
    }
}
