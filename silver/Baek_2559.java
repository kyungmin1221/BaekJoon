package BaekJoon.silver;


// 수열 //

// 누적 합 // 투 포인터 // 슬라이딩 윈도우

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2559 {
    public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          StringTokenizer st = new StringTokenizer(br.readLine());
          int N = Integer.parseInt(st.nextToken());
          int M = Integer.parseInt(st.nextToken());
          int[] A = new int[N];

          st = new StringTokenizer(br.readLine());
          for(int i=0; i<N; i++) {
              A[i] = Integer.parseInt(st.nextToken());
          }
          int answer = 0;
          int sum = 0;
          for(int i=0; i<M; i++) {
              sum += A[i];
          }
          answer = sum;
          for(int i=M; i<N; i++) {        // 그 다음 3개씩 합을 계산하기 위해 새로운 for문 작성
            sum += (A[i] - A[i-M]);
            answer = Math.max(sum,answer);          // sum, answer 중 더 큰값을 answer 에 저장
         }

        System.out.println(answer);


    }
}



