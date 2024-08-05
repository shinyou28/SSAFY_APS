package SWEA_2001_파리퇴치;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 갯수

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 배열의 크기
            int M = sc.nextInt(); // 파리채의 크기
            int max = 0; // 파리채로 최대로 많이 잡을 수 있는 파리의 갯수

            int[][] arr = new int[N][N];

            // NXN 배열에 들어가는 파리의 갯수 입력
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // MxM 파리채로 잡을 수 있는 최대 파리 수 찾기
            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    int sum = 0;
                    for (int x = i; x < i + M; x++) {
                        for (int y = j; y < j + M; y++) {
                            sum += arr[x][y];
                        }
                    }
                    if (sum > max) {
                        max = sum;
                    }
                }
            }
            System.out.println("#" + tc + " " + max);
        }

    }
}
