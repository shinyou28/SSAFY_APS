package SWEA_3289_서로소_집합;

import java.util.Scanner;

public class Solution {
	
	static int[] parent;
	static int n;
	static int m;
	static int question;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			parent = new int[n + 1];
			
			for(int i = 1; i <= n; i++) {
				parent[i] = i;
			}
			
			
			String answer = "#" + tc + " ";
			for(int i = 0; i < m; i++) {
				question = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				if(question == 0) {
					union(a, b);
				} else {
					if(checkSame(a,b)) {
						answer += '1';
					} else {
						answer += '0';
					}
					
				}
			}
			System.out.println(answer);
		}
	}
	
	public static int find(int x) {
//		if(parent[x] == x) {
//			return x;
//		} else {
//			return parent[x] = find(parent[x]);
//		}
		if(x != parent[x]) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x != y) {
			parent[y] = x;
		}
	}
	
	public static boolean checkSame(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
