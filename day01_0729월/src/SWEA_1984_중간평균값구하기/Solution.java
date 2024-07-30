package SWEA_1984_중간평균값구하기;

import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr = new int[10];
 
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[j] = sc.nextInt(); // 10개의 수 입력
            }
 
            int max = 0;
            int min = 10000;
            int sum = 0;
 
            for (int j = 0; j < arr.length; j++) {
                sum += arr[j];
 
                if (arr[j] > max) {
                    max = arr[j]; // 최대값
                }
                if (arr[j] < min) {
                    min = arr[j]; // 최소값
                }
            }
 
            double avg = (double) (sum - max - min) / (arr.length - 2);
            System.out.println("#" + (i + 1) + " " + Math.round(avg));
        }
 
    }
}
