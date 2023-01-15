package BaekJoon;

import java.util.Scanner;

public class baek_2750 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int A[] = new int[N];   // 크기가 N 인 배열 생성  = 5
        for(int i=0; i<N; i++) {
            A[i] = scanner.nextInt();
        }
        for(int i=0; i<N-1; i++) {            // 0 ~ 4
            for (int j = 0; j < N - 1 - i; j++) {       // 0 ~ 4-i
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
        for(int i=0; i<N; i++) {
            System.out.println(A[i]);
        }
    }
}
