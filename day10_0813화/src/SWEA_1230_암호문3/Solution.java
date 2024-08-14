package SWEA_1230_암호문3;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int currentSpeed = 0;
            int distance = 0;
            for (int i = 0; i < N; i++) {
                int cm = sc.nextInt();
                if (cm == 1) { 
                    int speed = sc.nextInt(); 
                    currentSpeed += speed;
                } else if (cm == 2) {
                    int speed = sc.nextInt();
                    currentSpeed -= speed;
                    if (currentSpeed < 0) {
                        currentSpeed = 0;
                    }
                }
                distance += currentSpeed;
            }
            System.out.println("#" + tc + " " + distance);
        }
    }
}
