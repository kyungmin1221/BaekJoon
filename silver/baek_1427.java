package BaekJoon.silver;

// 소트 인사이드 //


import java.util.Scanner;

public class baek_1427 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int[] A = new int[str.length()];
        for(int i=0; i<str.length(); i++) {
            A[i] = Integer.parseInt(str.substring(i,i+1));     // 2 1 4 3 하나씩 배열에 삽입
        }
        for(int i=0; i<str.length(); i++) {
            int MAX = i;                                     // 현재위치를 최대값으로 일단 지정
            for(int j=i+1; j<str.length(); j++) {
                if(A[j] > A[MAX]) {
                    MAX =j;
                }
            }
            if(A[i] < A[MAX]) {        // 찾은 최댓값과 자리를 바꾸어 주는 작업
                int temp = A[i];
                A[i] = A[MAX];
                A[MAX] = temp;
            }
        }
        for(int i=0; i<str.length(); i++) {
            System.out.print(A[i]);
        }
    }
}
