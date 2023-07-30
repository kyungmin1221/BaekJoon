package BaekJoon;

// 블랙잭 //

// 브루트포스(Brute Forece) 알고리즘


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] A = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        int answer = 0;
        for (int i = 0; i < 3; i++) {
            sum += A[i];                    // [0] 부터 [2] 까지
        }
        answer = sum;

        for (int i = 3; i < n; i++) {
            sum += (A[i]-A[i-1]);
            answer = Math.max(sum,answer);
        }

    }
}
