import java.util.*;
import java.io.*;

class Main {
    static final int MAX = 50 + 10;
    static char[][] map;

    public static void dfs(int y, int x) {
        char cur = map[y][x];
        map[y][x] = 0;

        if(cur == '-' && map[y][x+1] == '-') {
            dfs(y, x+1);
        }
        if(cur == '|' && map[y+1][x] == '|') {
            dfs(y+1, x);
        }

    }
    public static void main(String[] args) throws IOException  {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new char[MAX][MAX];


        // 1. map에 정보 반영
        for(int i = 1; i <= N; i++) {
            String str = br.readLine();
            for(int j = 1; j <= M; j++) {
                map[i][j] = str.charAt(j-1); // String은 0 ~ M-1번까지 존재하므로 j-1
            }
        }
        int answer = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(map[i][j] != 0) { // 0이 있다면, 이미 방문했다는 의미
                    dfs(i, j);
                    answer++;
                }
            }
        }

        // 2. dfs 수행
        bw.write(String.valueOf(answer));

        // 3. 출력
        bw.close();
        br.close();
    }
}
