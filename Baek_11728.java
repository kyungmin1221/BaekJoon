package BaekJoon;

// 배열 합치기

// 두 배열의 원소를 합쳐서 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> answer = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken()); // 첫 번째 입력값을 N으로 저장
        int M = Integer.parseInt(st.nextToken()); // 두 번째 입력값을 M으로 저장

        int A[] = new int[N+M];


        st = new StringTokenizer(br.readLine()); // 두 번째 줄 입력을 위해 새로운 StringTokenizer 생성
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine()); // 세 번째 줄 입력을 위해 새로운 StringTokenizer 생성
        for (int i = 0; i < M; i++) {
            A[i+N] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        StringBuilder sb = new StringBuilder();

        for(int x : A) {
            sb.append(x+ " ");
        }
        System.out.println(sb);
    }
}

