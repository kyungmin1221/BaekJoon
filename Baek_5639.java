package BaekJoon;

// 이진검색트리 ( 이진탐색트리 ) //

// 재귀함수 이용

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek_5639 {
    static int[] tree = new int[10000];
    static void postOrder(int start, int end) {
        int i;
        if (start >= end) {
            return;
        }
        for (i = start+1; i < end; i++) {
            if(tree[start] < tree[i] )
                break;
        }
        
        // 재귀함수 - 생성된 역순으로 종료

        // i를 기준으로 왼쪽 서브트리를 후위순회한다.
        postOrder(start+1, i);
        // i를 기준으로 오른쪽 서브트리를 후위순회한다.
        postOrder(i, end);
        System.out.println(tree[start]);
        return ;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;
        String input;
        // 입력받기
        while((input = br.readLine()) != null)
            tree[i++] = Integer.parseInt(input);

        // 후위순회 호출
        postOrder(0, i);
    }
}