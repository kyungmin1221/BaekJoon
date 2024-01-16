package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다음 순열 //
// 조합론


public class Baek_10972 {

    static int N;
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        if(isCheckNum()) {
            for(int i=0; i<N; i++) {
                System.out.print(A[i] + " ");
            }
        } else {
            System.out.println("-1");
        }

    }

    // 정렬 가능 여부 리턴
    public static boolean isCheckNum() {
        int i = A.length-1;
        while(i>0 && A[i]<A[i-1]) {
            i--;
        }
        if(i<=0) {
            return false;
        }

        int j = A.length-1;
        while(A[j]<A[i-1]) {
            j--;
        }
        swap(i-1,j);    // swap(2,3)

        j = A.length-1;
        while(i<j) {
            swap(i,j);
            i++;
            j--;
        }
        return true;
    }

    // 숫자 swap 함수
    public static void swap(int i,int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
