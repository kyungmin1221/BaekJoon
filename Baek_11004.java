package BaekJoon;

// K 번째 수 //
// 퀵정렬


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11004 {
    public  static void quickSort(int[] arr) {
        quickSort(arr,0,arr.length-1);
    }
    private static void quickSort(int[] arr,int start,int end) {
        int part2 = partition(arr,start,end);
        if(start<part2-1) {
            quickSort(arr,start,part2-1);
        }
        if(part2<end) {
            quickSort(arr,part2,end);
        }
    }
    private static int partition(int[] arr, int start,int end) {
        int pivot = arr[(start+end)/2];
        while(start<=end) {
            while(arr[start] < pivot) {
                start ++;
            }
            while(arr[end] > pivot) {
                end --;
            }
            if(start <= end) {
                swap(arr,start,end);
                start++;
                end--;
            }
        }
        return start;
    }
    private static void swap(int[] arr,int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(arr);
        System.out.println(arr[K-1]);
    }
}
