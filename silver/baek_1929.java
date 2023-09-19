package BaekJoon.silver;


import java.util.Map;
import java.util.Scanner;

public class baek_1929 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int[] A = new int[N+1];
       //  System.out.println(A.length);
        for(int i=1; i <= N; i++) {
            A[i] = i;
        }
        for(int i=2; i< Math.sqrt(N); i++) {   // 2~3 까지
            if(A[i] == 0) {
                continue;
            }
            for(int j=i+i; j<=N; j = i+j ) {     // 4~ 16 까지 2의 배수를 0 으로 만들어줌 , 2
                A[j] = 0;
            }
        }

        for(int i = M; i<=N; i++) {
            if(A[i] != 0 ) {
                System.out.println(A[i]);
            }
        }

    }
}
