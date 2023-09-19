package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 첫 번째 입력값을 정수로 변환
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()); // 두 번째 입력값을 StringTokenizer로 분리
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken()); // 토큰을 정수로 변환하여 배열에 저장
        }
        int k = Integer.parseInt(br.readLine()); // 마지막 입력값을 정수로 변환

        Arrays.sort(A);

        int answer = 0;
        int lt = 0;
        int rt = n - 1;
        while (lt < rt) {
            int sum = A[lt] + A[rt];
            if (sum == k) {
                answer++;
                lt++;
                rt--;
            } else if (sum > k) {
                rt--;
            } else if (sum < k) {
                lt++;
            }
        }

        System.out.println(answer);
    }
}

