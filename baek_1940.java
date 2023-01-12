package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());    // 문자열을 토큰형식으로 쪼개서 사용
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());  // 띄어쓰기를 기준으로 함
        }
        Arrays.sort(A);
        int count = 0;
        int i=0;
        int j = N-1;

        while(i<j) {
            if(A[i]+A[j]<M) {
                i++;
            }else if (A[i]+A[j]>M) {
                j--;
            } else {
                count++;
                i++;
                j--;
            }
        }
        System.out.println(count);
        br.close();
    }
}
