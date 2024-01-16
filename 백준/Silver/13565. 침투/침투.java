// 24.01.16 침투 복습 - visited 없이
import java.util.*;
import java.io.*;

class Main {
    static final int MAX = 1000 + 10;
    static boolean[][] map;
    static int N, M;
    static boolean answer;

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void dfs(int x, int y) {
        if(x == N) {
            answer = true;
            return;
        }
        map[x][y] = false;
        for(int i = 0; i < 4; i++) {
            int newX = x + dirX[i];
            int newY = y + dirY[i];
            if(map[newX][newY]) {
                dfs(newX, newY);
            }
        }

    }
    public static void main(String[] args) throws IOException {
        
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 1. map에 정보반영
        map = new boolean[MAX][MAX];

        for(int i = 1; i <= N; i++) {
            String str = br.readLine();
            for(int j = 1; j <= M; j++) {
                map[i][j] = (str.charAt(j - 1) == '0' ? true : false);
            }
        }
        
        // 2. bfs 호출
        for(int j = 1; j <= M; j++) {
            if(map[1][j]) {
                dfs(1, j);
            }
        }

        // 3. 출력
        if(answer) bw.write("YES");
        else bw.write("NO");
        
        bw.close();
        br.close();
    }
}
