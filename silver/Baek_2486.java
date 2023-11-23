package BaekJoon.silver;

// 안전영역 //
// 그래프탐

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_2486 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int N;
    static int[][] map;
    static boolean[][] visited;

    static int safezone = 0;
    static void safe(int x, int y,int k) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,y});
        map[x][y] = 0;
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[0] + dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny]<=k && !visited[nx][ny]) {
                    map[nx][ny] = 0;
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx,ny});
                }
            }
        }
        countMap(x,y,map);
    }

    static void countMap(int x,int y,int[][] map) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,y});
        


        for(int i=0; i<4; i++) {

        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0; j<N; j++) {
                // 높이는 1이상 100 이하의 정수이다.
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int k =0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int max = map[i][j];
                k = Math.max(k,max);
            }
        }

        // int maxSafeZone = Integer.MIN_VALUE;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j]<=k) {
                    safe(i,j,k);
                    k--;
                    if(k==0) {
                        break;
                    }
                }
            }
        }




    }
}
