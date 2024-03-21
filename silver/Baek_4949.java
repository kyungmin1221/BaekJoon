package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Baek_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = bf.readLine();
            if (line.equals(".")) {      // 마지막 종료 조건
                break;
            }
            Stack<Character> stack = new Stack<>();
            boolean check = true;

            for (char x : line.toCharArray()) {
                if (x == '(' || x == '[') {
                    stack.push(x);
                } else if(x == ')') {
                    if(stack.isEmpty() || stack.peek() != '(') {
                        check = false;
                        break;
                    }
                    stack.pop();

                } else if(x == ']') {
                    if(stack.isEmpty() || stack.peek() != '[') {
                        check = false;
                        break;
                    }
                    stack.pop();
                }
            } // end foreach

            if(stack.isEmpty() && check) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        } // end while
        System.out.println(sb);
    }
}