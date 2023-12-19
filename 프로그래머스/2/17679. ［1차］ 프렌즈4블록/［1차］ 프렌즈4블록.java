// 카카오 2018(2023.12.19) - 1차 복습
import java.util.*;

class Solution {
    static boolean[][] visited;
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] copy = new char[m][n];

        // board 배열의 행에 있는 문자열을 문자 배열로 반환 
        for(int i = 0; i < m; i++) {
            copy[i] = board[i].toCharArray();
        }

        boolean flag = true;
        while (flag) {
            visited = new boolean[m][n];
            flag = false;
            for(int i = 0; i < m-1; i++) {
                for(int j = 0; j < n-1; j++) {
                    if(copy[i][j] == '#') continue; // #은 빈칸을 의미
                    if(check(i, j, copy)) {
                        visited[i][j] = true;
                        visited[i][j+1] = true;
                        visited[i+1][j] = true;
                        visited[i+1][j+1] = true;
                        flag = true;
                    }
                }
            }
            answer += erase(m, n, copy);
            visited = new boolean[m][n];
        }
        return answer;
    }
    /* 2*2가 같은지 체크 */
    public static boolean check(int x, int y, char[][] board) {
        char ch = board[x][y];
        
        if(ch == board[x][y+1] && ch ==board[x+1][y] && ch == board[x+1][y+1]) {
            return true;
        }
        return false;
    }
    public static int erase(int m, int n, char [][] board) {
        int cnt = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j]) {
                    board[i][j] = '.'; // 빈공간을 나타냄
                }
            }
        }
        /* 큐를 이용해 세로로 제거 작업 진행 */
        for(int i = 0; i < n; i++) {
            Queue<Character> q = new LinkedList<>();
            for(int j = m-1; j >=0; j--) {
                if(board[j][i] == '.') {
                    cnt++; // 지우는 블록 카운트
                } else {
                    q.add(board[j][i]);
                }
            }
            int idx = m-1;
            // 삭제한 블록 위의 블록들 내리기
            while(!q.isEmpty()) {
                board[idx--][i] = q.poll();
            }
            // 빈칸 채우기
            for(int j = idx; j >=0; j--) {
                board[j][i] = '#';
            }
        }
        return cnt;
    }
}