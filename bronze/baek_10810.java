package BaekJoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 공 넣기 //
// 시뮬레이션, 구현

public class baek_10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());   // 바구니 갯수
        int M = Integer.parseInt(st.nextToken());   // 공을 넣을 횟수
        int[] box = new int[N+1];

        for(int t=0; t<M; t++) {
            st = new StringTokenizer(bf.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for(int u=i; u<=j; u++) {
                box[u] = k;
            }
        }
        for(int i=1; i<=N; i++) {
            System.out.print(box[i]+ " ");
        }
    }
}
