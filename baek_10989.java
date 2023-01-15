package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(bf.readLine());
        int[] A = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(A);   // 오름차순 정렬
        for(int i=0; i<N; i++) {
            sb.append(A[i]).append('\n');
        }
        System.out.println(sb);
    }
}

