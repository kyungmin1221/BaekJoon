package BaekJoon;

import java.util.Scanner;

// 평균 구하기 //

public class AverageNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int A[] = new int[n];

        for(int i=0; i<n; i++) {
            A[i] = scanner.nextInt();
        }

        long sum=0;
        long max=0;

        for(int i=0; i<n; i++) {
            if(A[i]>max) max = A[i];

            sum = sum + A[i];


        }
        System.out.println(sum*100.0/max/n);
    }
}
