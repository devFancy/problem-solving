// 24.01.12 (금) 2차 복습

import java.io.*;
import java.util.*;

class Main {
    static final int MAX = 50 + 10;
    static boolean[][] map;
    static boolean[][] visited;
    static int N, M, K, T;
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    static void dfs(int y, int x) {
        visited[y][x] = true;
        for(int i = 0; i < 4; i++) {
            int newX = x + dirX[i];
            int newY = y + dirY[i];
            if(map[newY][newX] && visited[newY][newX] == false) {
                dfs(newY, newX);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            map = new boolean[MAX][MAX];
            visited = new boolean[MAX][MAX];

            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new boolean[MAX][MAX];
            visited = new boolean[MAX][MAX];

            // 1. map에 연결정보 반영
            int x, y;
            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken()); // 가로
                y = Integer.parseInt(st.nextToken()); // 세로
                map[y+1][x+1] = true;
            }

            // 2. dfs 호출
            int answer = 0;
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= M; j++) {
                    if(visited[i][j] == false && map[i][j]) {
                        answer++;
                        dfs(i, j);
                    }
                }
            }
            // 3. 출력
            bw.write(String.valueOf(answer));
            bw.newLine();

        }
        bw.close();
        br.close();
    }
    
}
