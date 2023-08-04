package BaekJoon;

import java.util.Scanner;
import java.util.Stack;

public class baek_1874 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = scanner.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        StringBuilder bf = new StringBuilder();
        int num = 1;
        boolean result = true;
        for(int i=0; i<N; i++) {
            int su = A[i];
            if(su >= num) {
                while(su >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }
            else {
                int n = stack.pop();
                System.out.println("n : " + n);
                if(n>su) {
                    System.out.println("NO");
                    result = false;
                    break;
                }
                else {
                    bf.append("-\n");
                }
            }
        }
        if(result) {
            System.out.println(bf.toString());
        }
    }
}
