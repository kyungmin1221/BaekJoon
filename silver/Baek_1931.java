package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 회의실 배정 //
// 그리디

public class Baek_1931 {
    static class myComparable implements Comparable<myComparable> {
        int start;
        int end;
        myComparable(int start , int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(myComparable o) {
            if(this.end>o.end) return 1;        // 종료시간을 기준으로 정렬
            else if(this.end<o.end) return -1;
            else return this.start-o.start;     // 만약 종료시간이 같다면 -> 시작시간으로 정렬
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<myComparable> list = new ArrayList<>();

        int N = Integer.parseInt(bf.readLine());

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int startPoint = Integer.parseInt(st.nextToken());
            int endPoint = Integer.parseInt(st.nextToken());
            list.add(new myComparable(startPoint,endPoint));
        }

        Collections.sort(list);     // startPoint 를 기준으로 오름차순 정렬

        int end = 0;
        int count = 0;
        for (myComparable x : list) {
            if (end <= x.start) {
                end = x.end;
                count++;
            }
        }
        System.out.println(count);
    }
}


