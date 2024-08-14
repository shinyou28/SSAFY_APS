package SWEA_1228_암호문1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) { // 10개의 테스트 케이스 처리
           int N = sc.nextInt(); // 원본 암호문의 길이
           ArrayList<Integer> arr = new ArrayList<>();
           // 원본 암호문 입력
           for(int i = 0; i < N; i++) {
        	   arr.add(sc.nextInt());
           }
           
           int order = sc.nextInt(); // 명령어의 개수
           
           for(int i = 0; i < order; i++) {
        	   sc.next(); // 'I' 입력
        	   int x = sc.nextInt();
        	   int y = sc.nextInt();
        	   // 삽입할 문자열
        	   List<Integer> toInsert = new ArrayList<>();
        	   for(int j = 0; j < y; j++) {
        		   toInsert.add(sc.nextInt());
        	   }
        	   arr.addAll(x, toInsert);
           }
           
           System.out.print("#" + tc + " ");
           for(int i = 0; i < 10; i++) {
        	   System.out.print(arr.get(i) + " ");
           }
           System.out.println();         
           
        }
        
    }
}
