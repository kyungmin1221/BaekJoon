package BaekJoon;

// 최소 공배수 //

import java.util.Scanner;

public class baek_1934 {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] result = new int[N];
        for(int i=0; i<N; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            result[i] = a*b / gcd(a,b);
        }
        for(int i=0; i<N; i++) {
            System.out.println(result[i]);
        }
        scanner.close();
    }
    public static int gcd(int a, int b) {
        if(b==0) {
            return a;
        }
        else {
            return gcd(b,a%b);
        }
    }
}
