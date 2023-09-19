package BaekJoon.silver;

// 괄호 //
// 스택

import java.io.*;
import java.util.Stack;

public class Baek_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());  // 문자열의 개수 N을 입력받습니다.
        for (int i = 0; i < N; i++) {  // N번만큼 문자열을 입력받아야 하므로 for문을 사용합니다.
            String input = bf.readLine();
            if (isVPS(input)) {  // 괄호 문자열이 올바른지 확인하는 함수입니다.
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean isVPS(String s) {  // 괄호 문자열이 올바른지 확인하는 함수입니다.
        Stack<Character> stack = new Stack<>();
        for (char x : s.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            } else {
                if (stack.isEmpty()) {
                    return false;  // 스택이 비어있는데 ')' 가 나왔다면 올바르지 않은 괄호 문자열입니다.
                }
                stack.pop();
            }
        }
        return stack.isEmpty();  // 모든 문자를 확인한 후 스택이 비어있으면 올바른 괄호 문자열입니다.
    }
}

