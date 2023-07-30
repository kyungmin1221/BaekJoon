package BaekJoon;

// 블랙잭 //

// 브루트포스(Brute Forece) 알고리즘


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_2789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] A = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int sum = 0;

        for(int i=0; i<n-2; i++) {
            int lt= i+1;
            int rt = n-1;
            while(lt<rt) {
                int answer = A[i] + A[lt] + A[rt];
                if(answer == m) {
                    sum = answer;
                    break;
                } else if (answer < m) {
                    sum = Math.max(sum,answer);
                    lt ++;
                } else {
                    rt --;
                }
            }
        }
        System.out.println(sum);

    }
}
