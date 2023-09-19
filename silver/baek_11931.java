package BaekJoon.silver;


// 수 정렬하기 4 //

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class baek_11931 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(bf.readLine());
        Integer[] A = new Integer[N];
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(A, Collections.reverseOrder());
        for (int i=0; i<N; i++) {
            sb.append(A[i]).append('\n');
        }
        System.out.println(sb);

    }
}
