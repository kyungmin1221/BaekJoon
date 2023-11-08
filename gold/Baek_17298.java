package BaekJoon.gold;

// 오큰수 //
// 스택(Stack)


import java.io.*;
import java.util.Stack;

public class Baek_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] A = new int[N];
        Stack<Integer> stack = new Stack<>();
        String[] str = bf.readLine().split(" ");
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(str[i]);
        }
        int[] answer = new int[N];
        stack.push(0);
        for(int i=1; i<N; i++) {
            while(!stack.isEmpty() && A[stack.peek()] < A[i] ) {
                answer[stack.pop()] = A[i];
            }
            stack.push(i);
        }
        // if 일 경우, { } 안을 한번만 수행하고 종료함을 숙지
        while(!stack.empty()) {
            answer[stack.pop()] = -1;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<N; i++) {
            bw.write(answer[i]+ " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
