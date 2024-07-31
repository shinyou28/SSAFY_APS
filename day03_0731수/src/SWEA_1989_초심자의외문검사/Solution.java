package SWEA_1989_초심자의외문검사;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스 갯수
        sc.nextLine(); // 개행 문자 소모
        int result = 2;

        for (int i = 0; i < T; i++) {
            String word = sc.nextLine(); // 단어 입력

            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == word.charAt((word.length()-1)-j)) {
                    result = 1;
                    continue;
                } else {
		                result = 0;
		                break;
                }
            }

            System.out.println("#"+(i+1)+" "+result);
        }

    }
}