package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_2822 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] A = new int[8];
        int count = 0;      // 총점을 저장할 변수
        for(int i=0; i < A.length; i++) {
            A[i] = Integer.parseInt(bf.readLine());
        }
        for(int i=0; i<A.length; i++) {
            for(int j=0; j<A.length; j++) {
                if(A[i]>A[j]) {

                }
            }
        }



    }
}
