package SWEA_1209_Sum;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int T = 10;
        
        for (int tc = 1; tc <= T; tc++) {
            
            int[][] arr = new int[100][100]; // 100X100 2차원 
            sc.nextInt();
            
            for(int i = 0; i < 100; i++) {
                for(int j = 0; j < 100; j++) {
                    arr[i][j] = sc.nextInt(); // 2차원 배열에 숫자 입력
                }
            }

            int colSumMax = 0;
            int rowSumMax = 0;
            int diaSum1 = 0;
            int diaSum2 = 0;
            
            for(int i = 0; i < 100; i++) {
                int colSum = 0;
                int rowSum = 0;
                for(int j = 0; j < 100; j++) {
                    rowSum += arr[i][j];
                    colSum += arr[j][i];
                }
                if (rowSum > rowSumMax) {
	                rowSumMax = rowSum;
                }
	                
                if (colSum > colSumMax) {
	                colSumMax = colSum;
                }    
            }

            for(int i = 0; i < 100; i++) {
                diaSum1 += arr[i][i]; // 첫번째 대각선의 합
                diaSum2 += arr[i][99-i]; // 두번째 대각선의 합
            }

            int diaSumMax = Math.max(diaSum1, diaSum2); // 각 대각선의 합 max 저장

            int max = Math.max(Math.max(colSumMax, rowSumMax), diaSumMax);

            System.out.println("#" + tc + " " + max);
            
        }
        
    }
}
