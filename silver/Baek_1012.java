package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 쭉 가면서 1인 지점에서 탐색 시작 -> 상하죄우를 보면서 1인지점은 0으로 바꿔줌 1이 없을때까지
// 끝나면 count 증가 -> count 출력

public class Baek_1012 {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int t;       // 테스트 케이스
    static int width,height;
    static int cabbage;     // 배추
    static int[][] box;     // 원본 배열
    static void DFS(int x, int y) {
        box[x][y] =0;
        for(int i=0; i<4; i++) {        // 상하좌우 탐색
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < height && ny >= 0 && ny < width) {
                if(box[nx][ny] == 1) {
                    box[nx][ny] = 0;
                    DFS(nx,ny);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(bf.readLine());
        int count = 0;
        for(int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            width = Integer.parseInt(st.nextToken());   // 10
            height = Integer.parseInt(st.nextToken());  // 8
            cabbage = Integer.parseInt(st.nextToken()); // 17
            box = new int[height + 1][width + 1];

            for (int k = 0; k < cabbage; k++) {
                st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                box[b][a] = 1;                  // 11  x  9 만듬 아래 오른쪽은 0으로 초기화
            }   // for k

            for(int h=0; h<height; h++) {
                for(int w=0; w<width; w++) {
                    if(box[h][w] == 1) {
                        count ++;
                        DFS(h,w);   // 1일 경우에 상하좌우를 살펴봄
                    }
                }
            }
            System.out.println(count);
            count = 0;
        }   // for t
    }
}
