package SWEA_7465_창용_마을_무리의_개수;

import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    
    static int N; // 마을에 사는 사람의 수
    static int M; // 서로를 알고 있는 사람의 관계 수
    static int[] parent; // 1번 - N번까지의 사람

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
        	
        	N = sc.nextInt();
        	M = sc.nextInt();
        	// 1번부터 N번까지 사람의 부모 노드
        	parent = new int[N + 1];
        	// 부모 노드를 자기 자신으로 초기화
        	for(int i = 1; i <= N; i++) {
        		parent[i] = i;
        	}
        	
        	for(int i = 0; i < M; i++) {
        		int a = sc.nextInt();
        		int b = sc.nextInt();
        		
        		union(a, b);
        	}
        	
        	HashSet<Integer> set = new HashSet<>();
        	
        	// 각자 부모 노드를 찾는다.
        	for(int i = 1; i <= N; i++) {
        		set.add(find(i));
        	}
        	
        	System.out.println("#" + tc + " " + set.size());
        	
        }	

    }
    
    public static int find(int x) {
    	if(parent[x] == x) {
    		return x;
    	} else {
    		return parent[x] = find(parent[x]);
    	}
    }
    
    public static void union(int x, int y) {
    	x = find(x);
    	y = find(y);
    	
    	if(x != y) {
    		parent[y] = x;
    	}
    }
    

    
}
