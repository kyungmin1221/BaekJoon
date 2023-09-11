package BaekJoon;

// 제로 //
// 스택

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++) {
            int input = Integer.parseInt(bf.readLine());
            if(input == 0) {
                stack.pop();
            }
            else {
                stack.push(input);
            }
        }
        int answer = 0;
        for(int x : stack) {
            answer += x;
        }
        System.out.println(answer);
    }
}
