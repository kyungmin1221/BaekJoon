package BaekJoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_10811 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] box = new int[N+1];

        for(int i=1; i<=N; i++) {
            box[i] = i;
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(bf.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            for(int k=left; k<=right; k++,right--) {
                int nn = right;

                int temp = box[k];
                box[k] = box[nn];
                box[nn] = temp;

            }
        }
        for(int i=1; i<=N; i++) {
            System.out.print(box[i]+ " ");
        }

    }
}
