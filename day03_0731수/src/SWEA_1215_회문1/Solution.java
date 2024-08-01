package SWEA_1215_회문1;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[][] arr = new char[8][8]; // 8X8 배열
		int length = sc.nextInt(); // 찾아야 하는 회문의 길이	
		int cnt = 0; // 찾은 회문의 갯수
		
		for(int i = 0; i < 8; i++) {
			String word = sc.next();
			for(int j = 0; j < 8; j++) {
				arr[i][j] = word.charAt(j); // 8x8 배열에 글자 입력
			}
		}
		
		// 1행부터 8행까지 회문 찾기
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j <= 8-length; j++) {
				if(arr[i][j] == arr[i][j+(length-1)]) {
						cnt += 1;
						continue;
				} else {
						cnt = 0;
						break;
				}
			}
		}
		
		// 1열부터 8열까지 회문 찾기
		for(int i = 0; i <= 8-length; i++) {
			for(int j = 0; j <= 8; j++) {
				if(arr[i][j] == arr[i+(length-1)][j]) {
						cnt += 1;
						continue;
				} else {
						cnt = 0;
						break;
				}
			}
		}

		System.out.println(cnt);
	}
}