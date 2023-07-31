package BaekJoon;

// 수 찾기 //

// 이진탐색

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        // 이진탐색을 위해 오름차순 정렬
        Arrays.sort(A);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            boolean answer = false;
            int target = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = A.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                int midv = A[mid];
                if(midv>target) {
                    end = mid-1;
                } else if (midv<target) {
                    start = mid+1;
                }else {
                    answer = true;
                    break;
                }
            }
            if(answer) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
