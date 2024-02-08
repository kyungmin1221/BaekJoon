package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 병합 정렬 //

public class Baek_24060 {
        static int[] A;
        static int[] cpy;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        A = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        cpy = new int[A.length];

        System.out.print("초기 배열 : ");
        for(int i=0; i<A.length; i++) {
            System.out.print(A[i]+ " ");
        }
        System.out.println();
        mergeSort(0,A.length-1);

        System.out.print("병합정렬을 한 후 : ");
        for(int i=0; i<A.length; i++) {
            System.out.print(A[i]+ " ");
        }
    }

    static void mergeSort(int start, int end) {
        if(start<end) {
            int mid = (start + end ) / 2;
            mergeSort(start,mid);
            mergeSort(mid+1,end);

            int a = start;
            int b = mid+1;
            int index = a;

            while(a<=mid || b<=end) {
                if(end<b || (a<=mid && A[a] < A[b]) ) {
                    cpy[index++] = A[a++];
                } else {
                    cpy[index++] = A[b++];
                }
            }

            for(int i=start; i<=end; i++) {
                A[i] = cpy[i];
            }
        }
    }

}
