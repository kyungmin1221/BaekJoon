package BaekJoon;

import java.util.Scanner;

public class baek_11047 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();    // 동전 개수
        int K = scanner.nextInt();    // 목표 금액
        int[] A = new int[N];
        int count = 0;             // 동전 갯수 초기화
        for(int i=0; i<N; i++) {
            A[i] = scanner.nextInt();
        }
        for(int i=N-1; i>=0; i--) {       // 큰 금액 부터 찾아야하므로 큰수 -> 작은수
            if(A[i]<=K) {
                count += K/A[i];         // 몫은 카운트
                K =  (K % A[i]);         // 나머지는 K로
            }
        }
        System.out.println(count);
    }
}
