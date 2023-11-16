package BaekJoon.bronze;


// 공 바꾸기 //
// 시뮬레이션

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_10813 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N+1];
        for(int i=1; i<=N; i++) {
            A[i] = i;
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(bf.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            int temp = A[right];
            A[right] = A[left];
            A[left] = temp;

        }

        for(int i=1; i<=N; i++) {
            System.out.print(A[i]+" ");
        }
    }
}
