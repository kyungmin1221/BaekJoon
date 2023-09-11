package BaekJoon;

// 쇠막대기 //

// 스택
//  ( ) 은 레이저
// ( ~~~ ) 은 한개의 나무 토막을 의미
// 나무 토막이 레이저로 잘린 수를 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        // charAt() 을 이용하기 위해 foreach 보다는 for문 사용
        for(int i=0; i<input.length(); i++) {
            // '(' 을 만나면 스택에 푸쉬
            if(input.charAt(i) == '(') {
                stack.push('(');
            }
            // ')' 를 만난다면
            else {
                // 스택에서 pop() 을 하고
                stack.pop();
                // ')' 앞의 문자를 확인
                // ')' 의 앞의 문자가 '(' 라면 "레이저" 이므로 answer 에 남은 토막(즉 스택의 size 를 저장 )
                if(input.charAt(i-1) == '(') {
                    answer += stack.size();
                    // ')' 의 앞의 문자가 ')' 라면 "막대의 끝" 을 의미 하므로 answer 에 1 을 저장한다.
                } else {
                    answer ++;
                }
            }
        }
        System.out.println(answer);
    }
}
