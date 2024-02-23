package BaekJoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_10026 {
    static int n;
    static char[][] colorBox;
    static boolean[][] visited;
    static int countSee,countSeeRG,countSeeBlue;        // 전역변수 자제
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    // 정상
    static int colorSee(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] nowcColor = queue.poll();
            for(int i=0; i<4; i++) {  // magic number
                int nx = nowcColor[0] + dx[i];
                int ny = nowcColor[1] + dy[i];

                if(nx >= 0 && nx < n && ny >=0 && ny < n && !visited[nx][ny] && colorBox[nx][ny] == colorBox[x][y]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
        countSee ++;
        return countSee;
    }

    // 빨강 , 녹색만 처리하는 함수
    static int colorSeeRedGreen(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] nowColor = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = nowColor[0] + dx[i];
                int ny = nowColor[1] + dy[i];

                if(nx >= 0 && nx < n && ny >=0 && ny < n
                        && !visited[nx][ny] && colorBox[nx][ny] != 'B') {   // 필요한것만 사용할 수 ㅇ있도록 조건문 변경

                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
        countSeeRG ++;
        return countSeeRG;
    }

    // 파랑만 처리하는 함수      -> 삭제
//    static int colorSeeBlue(int x, int y) {
//        Queue<int[]> queue = new LinkedList<>();
//        queue.offer(new int[] {x, y});
//        visited[x][y] = true;
//
//        while(!queue.isEmpty()) {
//            int[] nowColor = queue.poll();
//            for(int i=0; i<4; i++) {
//                int nx = nowColor[0] + dx[i];
//                int ny = nowColor[1] + dy[i];
//
//                if(nx >= 0 && nx < n && ny >=0 && ny < n
//                        && !visited[nx][ny] && colorBox[nx][ny] == colorBox[x][y]) {
//                    visited[nx][ny] = true;
//                    queue.offer(new int[] {nx, ny});
//                }
//            }
//        }
//        countSeeBlue ++;
//        return countSeeBlue;
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        colorBox = new char[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++) {
            String line = bf.readLine();;
            for(int j=0; j<n; j++) {
                colorBox[i][j] = line.charAt(j);
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(visited[i][j]) {
                    continue;
                }
                if(colorBox[i][j] == 'R' ) {
                    colorSee(i,j);
                }
                if(colorBox[i][j] == 'G') {
                    colorSee(i,j);
                }
                if(colorBox[i][j] == 'B') {
                    colorSee(i,j);
                }
            }
        }
        System.out.println(countSee);       // 전역변수 사용 자제

        visited = new boolean[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if( (colorBox[i][j] == 'R' || colorBox[i][j] == 'G') && !visited[i][j]) {
                    colorSeeRedGreen(i,j);
                }

                if(colorBox[i][j] == 'B' && !visited[i][j]) {
                   // colorSeeBlue(i,j);
                    colorSee(i,j);
                }
            }
        }

        System.out.println(countSeeRG + countSeeBlue);

    }
}
