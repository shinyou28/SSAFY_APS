package SWEA_2806_N_Queen;

import java.util.Scanner;

public class Solution {
    static int count = 0;
    static int[] sel; // 퀸이 놓인 열의 위치

    // 퀸을 해당 위치에 놓을 수 있는지 확인
    static boolean check(int N, int row, int col) {
        for (int i = 0; i < row; i++) {
            // 같은 열에 있거나 대각선에 있는 경우 놓을 수 없음
            if (sel[i] == col || Math.abs(i - row) == Math.abs(sel[i] - col)) {
                return false;
            }
        }
        return true;
    }

    static void nQueen(int N, int row) {
        if (row == N) { // 모든 퀸을 놓은 경우
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (check(N, row, i)) { // 현재 위치에 퀸을 놓을 수 있는지 확인
                sel[row] = i;
                nQueen(N, row + 1); // 다음 행으로 이동
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            sel = new int[N];
            count = 0;
            nQueen(N, 0);
            System.out.println("#" + tc + " " + count);
        }
    }
}
