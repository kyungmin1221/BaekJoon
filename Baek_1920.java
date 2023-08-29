package BaekJoon;

// 수 찾기 //

// 이진탐색(이분탐색)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        // 오름차순 정렬
        // 1 2 3 4 5
        // 그리고 찾으려하는 배열과 비교
        Arrays.sort(A);

        int M = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        
        for(int i=0; i<M; i++) {
            boolean answer = false;
            int start = 0;
            int end = A.length - 1;
            int target = Integer.parseInt(st.nextToken());

            while (start <= end) {
                int mid = (start + end) / 2;
                int midValue = A[mid];
                if (midValue > target) {
                    end = mid - 1;
                } else if (midValue < target) {
                    start = mid + 1;
                } else {
                    answer = true;
                    break;
                }
            }

            if (answer) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }

    }
}
