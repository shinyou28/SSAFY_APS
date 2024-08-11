package SWEA_6190_정곤이의_단조_증가하는_수;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스의 수
        
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // N개의 정수가 주어진다.
            int[] arr = new int[N];
            
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt(); // N개의 정수 입력
            }
            
            int maxNum = 0; // 단조 증가하는 수 중 최댓값
            
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                
                    int num = arr[i] * arr[j];
                    
                    if (isIncreasing(num)) { // 단조 증가하는 수인지 체크
                        if (num > maxNum) {
                            maxNum = num; // 더 큰 단조 증가 수가 있으면 업데이트
                        }
                    }
                }
            }
            
            System.out.println(maxNum);
        }
    }
    
    // 숫자가 단조 증가하는지 확인하는 함수
    public static boolean isIncreasing(int num) {
        int lastDigit = num % 10;
        num /= 10;
        
        while (num > 0) {
            int currentDigit = num % 10;
            if (currentDigit > lastDigit) {
                return false; // 단조 증가가 아닌 경우
            }
            lastDigit = currentDigit;
            num /= 10;
        }
        
        return true; // 단조 증가하는 수
    }
}

