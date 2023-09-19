package BaekJoon.silver;


// 점수 계산 //

import java.util.Arrays;
import java.util.Scanner;

public class baek_2822 {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int[] A = new int[8];      // 일반 숫자를 담을 배열 선언
        for(int i=0; i<A.length; i++) {
            A[i] = scanner.nextInt();        // 배열에 숫자 랜덤 저장
        }
        int[] num = new int[8];           // 무작위로 숫자를 담을 배열 선언
        int[] MAX = new int[5];          // 최댓값 5개를 뽑아 저장할 배열
        int count = 0;                // 배열 숫자를 카운트할 변
        int sum = 0;                  // 합을 저장할 변수
        for(int i=0; i<8; i++) {
            num[count] = A[i];
            count++;
        }
        count = 0;
        Arrays.sort(A);       // 배열들을 오름차순으로 저장
        for(int i=3; i<8; i++) {
            MAX[count] = A[i];
            sum += MAX[count];
            count++;
        }
        System.out.println(sum);
        for(int i=0; i<8; i++) {
            for(int j=0; j<5; j++) {
                if(num[i]==MAX[j]) {
                    System.out.print(i+1+" ");
                }
            }
        }
    }
}
