import java.util.*;

class Solution {
  public class position {
    int x;
    int y;

    public position(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  int[] nx = {-1, 1, 0, 0};
  int[] ny = {0, 0, -1, 1};
  public int solution(int[][] maps) {
    int h = maps.length;
    int w = maps[0].length;

    Queue<position> q = new LinkedList<>();
    q.add(new position(0,0));

    boolean[][] visited = new boolean[h][w];
    visited[0][0] = true;

    position p;
    while (!q.isEmpty()) {
      p = q.poll();
      int x = p.x;
      int y = p.y;

      for(int i=0; i<4; i++) {
        int next_x = x + nx[i];
        int next_y = y + ny[i];

        if (0 <= next_x && next_x < h && 0 <= next_y && next_y < w){
          if(visited[next_x][next_y] == false && maps[next_x][next_y] > 0) {
            visited[next_x][next_y] = true;
            maps[next_x][next_y] = maps[x][y] + 1;
            q.add(new position(next_x, next_y));
          }
        }
      }
    }
    return maps[h-1][w-1] == 1 ? -1 : maps[h-1][w-1];
  }
}