package BaekJoon;

// DNA 비밀번호 // 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_12891 {
    static int checkArr[];
    static int myArr[];
    static int checkSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int S = Integer.parseInt(st.nextToken());   // 4
        int P = Integer.parseInt(st.nextToken());    // 2
        int Result = 0;
        char A[] = new char[S];       // 4 배열
        checkArr = new int[4];
        myArr = new int[4];
        checkSecret = 0;
        A= bf.readLine().toCharArray();          // GATA
        st = new StringTokenizer(bf.readLine());        // 1 0 0 1
        for(int i=0; i<4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());    // 띄어쓰기 기준으로 문자열 읽음
            if (checkArr[i]==0) {
                checkSecret++;
            }
        }

        for(int i=0;i<P; i++) {
            Add(A[i]);
        }
        if(checkSecret == 4) {
            Result++;
        }
        for(int i=P; i<S; i++) {
            int j = i-P;
            Add(A[i]);
            Remove(A[j]);
            if(checkSecret==4) {
                Result++;
            }
        }
        System.out.println(Result);
        bf.close();
    }
    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if(myArr[0]==checkArr[0]) checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if(myArr[1]==checkArr[1]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if(myArr[2]==checkArr[2]) checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if(myArr[3]==checkArr[3]) checkSecret++;
                break;
        }
    }
    private static void Remove(char c) {
        switch (c) {
            case 'A':

                if(myArr[0]==checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if(myArr[1]==checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if(myArr[2]==checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if(myArr[3]==checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }
}

