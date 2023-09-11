package BaekJoon;

// 수 정렬하기 //
// 버블정렬 - 배열의 앞에서부터 앞+1 을 차례대로 비교해나가면서 정렬한다
// 시간복잡도 O(N^2)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<N-1; j++) {
                if(A[j] > A[j+1]) {
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }
        for(int s :A) {
            System.out.println(s);
        }
    }
}
