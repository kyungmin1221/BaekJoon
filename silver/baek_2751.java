package BaekJoon.silver;


// 수 정렬하기 2 //

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder st = new StringBuilder();
        int N = Integer.parseInt(bf.readLine());
        int[] A = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(A);

        for(int i=0; i<N; i++) {
            st.append(A[i]).append('\n');
        }
        System.out.println(st);

    }
}
