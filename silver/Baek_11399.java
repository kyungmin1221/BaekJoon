package BaekJoon.silver;


// ATM //
// 수 정렬
// 삽입 정렬 - 선택 데이터를 현재 정렬된 데이터 범위 내에서 적절한 위치에 삽입하는 것
// 시간 복잡도 : O(N^2)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];       // 배열 정렬
        int[] S = new int[N];       // 배열의 합 정렬 - 1+3+6+...+13
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<N-1; j++) {
                if(A[j]>A[j+1]) {
                    int temp = A[j + 1];
                    A[j + 1] = A[j];
                    A[j] = temp;
                }
            }
        }
        S[0] = A[0];
        for(int i=1; i<N; i++){
            S[i] = S[i-1] + A[i];
        }
        int sum = 0;
        for(int i=0; i<N; i++) {
            sum += S[i];
        }
        System.out.println(sum);
    }
}
