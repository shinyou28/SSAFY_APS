package SWEA_2068_최대수구하기;

import java.util.Scanner;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
        int[] arr = new int[10];
        int max = 0;
         
        for(int i = 0; i < T; i++) {
             
            for(int j = 0; j < arr.length; j++) {
                arr[j] = sc.nextInt(); // 10개의 수 입력
            }
             
            for(int j = 0; j < arr.length; j++) {
                if(arr[j]>max) {
                    max = arr[j];
                }
            }
             
            System.out.println("#"+(i+1)+" "+max);
            max = 0;
             
        }
         
    }
}