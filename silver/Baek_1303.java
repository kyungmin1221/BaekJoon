package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_1303 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n,m;
    static int[][] box;
    static boolean[][] visited;

    static int whiteSoldier(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new int[] {x, y});
        int whiteCount = 1;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx>=0 && nx<m && ny>=0 && ny<n && !visited[nx][ny] && box[nx][ny] == 'W') {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny});
                    whiteCount ++;
                }
            }
        } // end while
        whiteCount *= whiteCount;

        return whiteCount;
    }

    static int blackSoldier(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new int[] {x, y});
        int blackCount = 1;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx>=0 && nx<m && ny>=0 && ny<n && !visited[nx][ny] && box[nx][ny] == 'B') {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny});
                    blackCount ++;
                }
            }
        } // end while
        blackCount *= blackCount;

        return blackCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        box = new int[m][n];
        visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
            String line = bf.readLine();
            for(int j=0; j<n; j++) {
                box[i][j] = line.charAt(j);
            }
        }
        int totalWhiteCount = 0;
        int totalBlackCount = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(box[i][j] == 'W' && !visited[i][j]) {
                    totalWhiteCount += whiteSoldier(i,j);
                }
                if(box[i][j] == 'B' && !visited[i][j]) {
                    totalBlackCount += blackSoldier(i,j);
                }
            }
        }
        System.out.println(totalWhiteCount+" "+totalBlackCount);
    }
}
