package BaekJoon.bronze;


// 두 수 비교하기 //

import java.util.Scanner;

public class baek_1330 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        if(A>B) {
            System.out.println(">");
        } else if (A<B) {
            System.out.println("<");
        }
        else {
            System.out.println("==");
        }
    }
}
