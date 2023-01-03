package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class Divisor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();    // 2
        int[] divisor = new int[N];    // 배열 생성

        for(int i=0; i<N; i++) {
            divisor[i] = scan.nextInt();      // 2 4 입력 - 1,8제외
        }
        Arrays.sort(divisor);

        int min = divisor[0];
        int max = divisor[N-1];

        System.out.println(min*max);


    }
}
