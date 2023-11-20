package BaekJoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_7576 {
    static int M,N;
    static int[][] tomato;  // 토마토 상자 배열
    static int[][] dis;     // 토마토 일수를 저장할 배열
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static void Tomato () {
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(tomato[i][j]  == 1) {
                    queue.offer(new int[] {i,j});
                }
            }
        }
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                if(nx>=0 && ny>=0 && nx<N && ny<M) {
                    if(tomato[nx][ny] == 0) {
                        tomato[nx][ny] = 1;
                        dis[nx][ny] =  dis[temp[0]][temp[1]] + 1;
                        queue.offer(new int[] {nx,ny} );
                    }
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());   // 상자의 가로 칸 수 = 6
        N = Integer.parseInt(st.nextToken());   // 상자의 세로 칸 수 = 4
        tomato = new int[N][M];         // 4 x 6 배열
        dis = new int[N][M];

        boolean check = true;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<M; j++) {
                tomato[i][j]  = Integer.parseInt(st.nextToken());
                if(tomato[i][j]==0) {
                    check = false;  // 익지 않은게 단 하나라도 있으면 0을 출력할 필요 X
                }
                if(tomato[i][j]==1) {
                    dis[i][j] = 0;  // 익어있는 칸의 dis는 0으로 초기화하여 +1을 히면 1일이 될 수 있게함 ( 0+1 = 1일 )
                }
            }
        }

        if(check) {      // 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력
            System.out.println(0);
            return;     // 프로그램 종료
        } else {
            Tomato();
        }

        int count = 1;
        boolean flag = true;

        for(int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomato[i][j] == 0)  // 토마토가 모두 익지 못한 상황이 있을 경우
                    flag = false;
            }
        }

        if (flag) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    count = Math.max(count,dis[i][j]); // dis 배열에서 가장 큰 count 값을 찾으면 그것이 최소 날짜
                }
            }
            System.out.println(count);  // 모두 익을 때까지의 최소 날짜를 출력
        } else {
            System.out.println(-1);  //  토마토가 모두 익지는 못하는 상황이면 -1 출력
        }
    }
}
