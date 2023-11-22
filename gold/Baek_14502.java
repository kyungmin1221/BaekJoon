package BaekJoon.gold;

// 연구소 //
// 구현
// broute force
// bfs

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 함
// 0 : 빈칸,  1: 벽, 2: 바이러스
public class Baek_14502 {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int N,M;
    static int[][] virusmap;
    static int maxsafezone = Integer.MIN_VALUE;   // 안전구역의 최대 개수를 위해 최솟값을 저장해둘 변수 설정

    static void countWall(int wallcount) {  // 벽(1)의 개수가 3개가 되면 안전구역을 찾을 함수(bfs)를 불러줄 함수(dfs)
        if(wallcount == 3) {
            countsafezone();
            return; // 종료하고 재귀함수
        }
        for(int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                if(virusmap[i][j] == 0) {
                    virusmap[i][j] = 1;
                    countWall(wallcount+1);
                    virusmap[i][j] = 0;    // 함수가 끝나면 다시 벽을 없애준다.
                }
            }
        }
    }

    static void countsafezone() {
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                if( virusmap[i][j] == 2) {      // 바이러스가 있는 곳이라면
                    queue.offer(new int[] {i,j});
                }
            }
        }
        int copyvirusmap[][] = new int[N][M];
        for(int i=0; i<N; i++) {
            copyvirusmap[i] = virusmap[i].clone();      // 배열의 깊은 복사 => 복사 배열이 수정된다해도 원본 배열에 영향을 주지 못함
        }
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<M && copyvirusmap[nx][ny] == 0) {
                    queue.offer(new int[] {nx,ny} );
                    copyvirusmap[nx][ny] = 2;
                }
            }
        }
        findsafezone(copyvirusmap);
    }

    static void findsafezone(int[][] copyvirusmap) {
        int safezone = 0;
        for(int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                if(copyvirusmap[i][j] == 0) {
                    safezone ++;
                }
            }
        }
        if(safezone > maxsafezone) {
            maxsafezone = safezone;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        virusmap = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                virusmap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        countWall(0);
        System.out.println(maxsafezone);
    }
}
