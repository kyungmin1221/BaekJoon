package BaekJoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_17144 {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] box;
    static int head, foot;
    static int r,c,t;

    static int[][] dust() {
        int[][] copymap = new int[r][c];

        copymap[head][0] = -1;
        copymap[foot][0] = -1;

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(box[i][j] > 0) {
                    copymap[i][j] += box[i][j];
                    for(int k=0; k<4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx>=0 && nx<r && ny>=0 && ny<c && box[nx][ny] != -1) {
                            copymap[nx][ny] += (box[i][j] / 5);
                            copymap[i][j] -= (box[i][j] / 5);
                        }
                    }
                }
            }
        }   // end for
        return copymap;
    }

    static void airup() {
        for(int i= head-1; i>0; i--) {
            box[i][0] = box[i-1][0];
        }
        for(int i=0; i<c-1; i++){
            box[0][i] = box[0][i+1];
        }
        for(int i=0; i<head; i++) {
            box[i][c-1] = box[i+1][c-1];
        }
        for(int i = c-1; i>1; i--) {
            box[head][i] = box[head][i-1];
        }

        box[head][1] = 0;
    }

    static void airdown() {
        for (int x = foot + 1; x < r - 1; x++) {
            box[x][0] = box[x + 1][0];
        }
        for (int y = 0; y < c - 1; y++) {
            box[r - 1][y] = box[r - 1][y + 1];
        }
        for (int x = r - 1; x > foot; x--) {
            box[x][c - 1] = box[x - 1][c - 1];
        }
        for (int y = c - 1; y > 1; y--) {
            box[foot][y] = box[foot][y - 1];
        }

        box[foot][1] = 0;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        box = new int[r][c];    // 7 x 8
        for(int i=0; i<r; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<c; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<r; i++) {
            if(box[i][0] == -1) {
                head = i;
                foot = i + 1;
                break;
            }
        }

        for(int i=0; i<t; i++) {
            box = dust();
            airup();
            airdown();
        }
        int sum = 2;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                sum += box[i][j];
            }
        }
        System.out.println(sum);
    }
}
