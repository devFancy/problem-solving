import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean [] checked;
    static int [][] arr;
    static int node, line;

    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        node = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());

        arr = new int[node+1][node+1];
        checked = new boolean[node+1];

        for(int i = 0; i < line; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }
        dfs(1);
        
        System.out.println(count-1);
    }
    public static void dfs(int start) {
        checked[start] = true;
        count++;

        for(int i = 0; i <= node; i++) {
            if(arr[start][i] == 1 && !checked[i]) {
                dfs(i);
            }
        }
    }
}