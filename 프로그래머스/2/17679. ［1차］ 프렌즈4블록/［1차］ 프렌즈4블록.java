import java.util.*;

class Solution {
    static boolean v[][]; // 체크 배열
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char copy [][] = new char[m][n];
        
        // 보드를 2차원 문자 배열로 복사합니다.
        for(int i = 0; i < m; i++) {
            copy[i] = board[i].toCharArray();
        }
        
        boolean flag = true;
        while(flag) {
            v = new boolean[m][n];
            flag = false;
            for(int i = 0; i < m-1; i++) {
                for(int j = 0; j < n-1; j++) {
                    if(copy[i][j] == '#') continue; // #은 빈칸을 의미합니다.
                    // 2x2 블록을 제거할 수 있는지 확인합니다.
                    if(check(i, j, copy)) {
                        v[i][j] = true;
                        v[i][j+1] = true;
                        v[i+1][j] = true;
                        v[i+1][j+1] = true;
                        flag = true; // 블록을 제거할 수 있는 경우 플래그를 true로 설정합니다.
                    }
                }
            }
            // 표시된 블록을 지우고 답의 카운트를 업데이트합니다.
            answer += erase(m, n, copy);
            v = new boolean[m][n]; // 체크 배열을 초기화합니다.
        }
        return answer;
    }

    // 특정 위치 (x, y)의 2x2 블록을 제거할 수 있는지 확인합니다.
    public static boolean check(int x, int y, char[][] board) {
        char ch = board[x][y];
        
        if(ch == board[x][y+1] && ch == board[x+1][y] && ch == board[x+1][y+1]) {
            return true;
        }
        return false;
    }

    // 표시된 블록을 지우고 남은 블록을 아래로 이동시키며 빈 공간을 채웁니다.
    public static int erase(int m, int n, char[][] board) {
        int cnt = 0; // 지워진 블록의 수를 세는 변수
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(v[i][j]) {
                    board[i][j] = '.'; // 표시된 블록을 지웁니다.
                }
            }
        }
        // 세로로 블록을 이동하는 작업을 큐를 이용해 수행합니다.
        for(int i = 0; i < n; i++) {
            Queue<Character> q = new LinkedList<>();
            for(int j = m-1; j >= 0; j--) {
                if(board[j][i] == '.') {
                    cnt++; // 지워진 블록의 카운트를 증가시킵니다.
                } else {
                    q.add(board[j][i]);
                }
            }
            int idx = m-1;
            // 남은 블록을 아래로 이동시킵니다.
            while(!q.isEmpty()) {
                board[idx--][i] = q.poll();
            }
            // 빈 공간을 '#'으로 채웁니다.
            for(int j = idx; j >= 0; j--) {
                board[j][i] = '#';
            }
        }
        return cnt; // 지워진 블록의 총 수를 반환합니다.
    }
}
