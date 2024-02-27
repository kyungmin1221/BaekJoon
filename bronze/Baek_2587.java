package BaekJoon.bronze;

import java.io.*;


public class Baek_2587 {
    static int n;
    static int quiz(String line) {
        int count = 0;
        int answer = 0;
        for(int i=0; i<line.length(); i++) {
            if(line.charAt(i) == 'O') {
                count ++;
                answer += count;
            } else {
                count = 0;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        String[] line = new String[n];
        for(int i=0; i<n; i++) {
            line[i] = bf.readLine();
        }
        int totalanswer = 0;
        for(int i=0; i<n; i++) {
            totalanswer = quiz(line[i]);
            System.out.println(totalanswer);
        }
    }
}
