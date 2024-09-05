package SWEA_1251_하나로;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	
	static int[] parent;

	// 간선 클래스 (두 섬 사이의 거리와 비용 정보를 저장)
	static class Edge implements Comparable<Edge> {
		int from, to;
		double cost;
		
		Edge(int from, int to, double cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		// 가중치를 기준으로 간선을 오름차순 정렬
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();  // 테스트 케이스 수

	}
	
}
