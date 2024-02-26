package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


// 입력은 가입순
// 나이순으로 출력
// 나이가 같으면 가입순으로 출력

public class Baek_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[][] member = new String[n][2];

        for(int i=0; i<n; i++) {
            String[] input = bf.readLine().split(" ");
            member[i][0] = input[0];
            member[i][1] = input[1];
        }

        Arrays.sort(member, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
            }
        });

        for(String[] mem : member) {
            System.out.println(mem[0]+ " " + mem[1]);

        }







    }
}
