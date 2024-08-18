package 신입사원_분반_교육;

import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 학생 수
            int min = sc.nextInt(); // 분반 별 최소 인원
            int max = sc.nextInt(); // 분반 별 최대 인원
             
            int[] score = new int[101]; // 점수 범위 : 0~100
            // 학생들의 점수를 입력
            for(int i = 0; i<N; i++) {
                score[sc.nextInt()]++;
            }
             
            int answer = Integer.MAX_VALUE; // 답을 저장할 변수, 초기값은 매우 큰 값으로 설정
            boolean result = false; // 유효한 분반이 있는지 확인
            
            // 두 개의 기준점(score1, score2)을 설정하여 분반을 나눔
            for(int score1 = 0; score1 < 101; score1++) {
                for(int score2 = score1 + 1; score2 < 101; score2++) {
                	
                    int group1 = 0;
                    int group2 = 0;
                    int group3 = 0;
                    // 첫 번째 분반
                    for(int k = 0; k < score1; k++) {
                        group1 += score[k];
                    }
                    // 두 번째 분반
                    for(int k = score1; k < score2; k++) {
                        group2 += score[k];
                    }
                    // 세 번째 분반
                    group3 = N - group1 - group2;
                     
                    // 각 분반이 최소 인원(min)과 최대 인원(max) 사이에 있는지 확인
                    if(group1 < min || group2 < min || group3 < min ||
                            group1 > max || group2 > max || group3 > max) {
                        continue; // 조건에 맞지 않으면 다음으로 넘어감
                    }
                    result = true; // 유효한 분반이 존재
                    
                    // 현재 분반들 중 최소값과 최대값을 구해 차이를 계산
                    int finalMin = Math.min(Math.min(group1, group2), group3);
                    int finalMax = Math.max(Math.max(group1, group2), group3);
                    answer = Math.min(answer, finalMax - finalMin); // 최소 차이를 갱신
                }
            }
             
            if(!result) answer = -1; // 유효한 분반이 없으면 -1을 출력
            System.out.println("#" + tc + " " + answer);
        }
    }
}
