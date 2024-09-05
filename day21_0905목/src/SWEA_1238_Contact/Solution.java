package SWEA_1238_Contact;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Edge {
	int w;

	public Edge(int w) {
		super();
		this.w = w;
	}
	
}

public class Solution {
	
	static List<Edge>[] graph;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();
			int start = sc.nextInt();
			
			graph = new ArrayList[101];
			for(int i = 0; i < graph.length; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < n / 2; i++) {
				int v = sc.nextInt();
				int w = sc.nextInt();
				
				graph[v].add(new Edge(w));
			}
			
			int result = bfs(start);
			System.out.println("#" + tc + " " + result);
		}
	}

	private static int bfs(int start) {
		boolean[] visit = new boolean[101];
		int[] depth = new int[101];
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(start);
		visit[start] = true;
		depth[start] = 0;
		
		int maxDepth = 0;
		int answer = 0;
		
		while(!q.isEmpty()) {
			int v = q.poll();
			
			for(Edge e : graph[v]) {
				if(!visit[e.w]) {
					visit[e.w] = true;
					depth[e.w] = depth[v] + 1;
					q.offer(e.w);
				}
				
				if(depth[e.w] > maxDepth || (depth[e.w] == maxDepth && e.w > answer)) {
					maxDepth = depth[e.w];
					answer = e.w;
				}
			}
		}
		return answer;
	}
	
}
