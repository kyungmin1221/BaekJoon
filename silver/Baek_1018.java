package BaekJoon.silver;

// 체스판 다시 칠하기 //
// brute force


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1018 {
    public static int Solution(int start,int end, String[] chess) {

        // 정답 기준 보드를 흰색바닥이 왼쪽 상단에 있다고 가정
        // "WBWBWBWB","BWBWBWBW" 를 %2 하면 2개가 반복되면서 밑으로 생성됨 (W->B->W->B ...)
        String[] whiteboard = {"WBWBWBWB","BWBWBWBW"};

        int white = 0;
        for(int i=0; i<8; i++) {
            int row = start + i;
            for(int j=0; j<8; j++) {
                int col = end + j;
                if(chess[row].charAt(col) != whiteboard[row % 2].charAt(j)) {
                    white++;
                }
            }
        }
        // 흰색 바닥의 최소 개수와 검정 바닥의 최소개수를 비교
        // 검정바닥의 개수 => 8x8 = 64, 즉 "64 - 흰색바닥" 의 개수가 검정바닥의 최소개수임
        return Math.min(white,64-white);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int H = Integer.parseInt(st.nextToken());       // 세로 3
        int W = Integer.parseInt(st.nextToken());       // 가로 4
        String[] chess = new String[H];

        for(int i=0; i<H; i++) {
            chess[i] = bf.readLine();
        }

        int max = Integer.MAX_VALUE;
        for(int i=0; i<= H-8; i++) {
            for(int j=0; j<= W-8; j++){
                int curCount = Solution(i,j,chess);
                if(max > curCount) {
                    max = curCount;     // 최소개수를 max 에 대입
                }
            }
        }
        System.out.println(max);
    }
}
