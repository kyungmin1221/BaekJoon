package BaekJoon.silver;

// 섬의 개수 //

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_4963 {
   //  대각선
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static int width;
    static int height;
    static int[][] island;
    static boolean[][] visited;


    static void Solution(int x,int y) { //          1. x=0, y=0
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,y});      // (0,0)
        island[x][y] = 0;
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();   // now[0] = 0, now[1] = 0
            for(int i=0; i<8; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx>=0 && nx<height && ny>=0 && ny<width && island[nx][ny] == 1 && !visited[nx][ny]) {
                    island[nx][ny] = 0;
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx,ny});
                    Solution(nx,ny);
                    }
                }
            }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            width = Integer.parseInt(st.nextToken());   // 너비 5
            height = Integer.parseInt(st.nextToken());  // 높이 4
            island = new int[height][width];            // 4 x 5
            visited = new boolean[height][width];

            if(width == 0 && height == 0) {
                break;
            }

            for (int i = 0; i < height; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < width; j++) {
                    island[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (island[i][j] == 1) {
                        answer++;
                        Solution(i, j);
                    }
                }
            }

            System.out.println(answer);


        }
    }
}
