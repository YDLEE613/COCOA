package Solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// DFS & BFS
public class _1260 {
	public static boolean adj[][];
	public static boolean visited[];
	public static StringBuilder sb;
	public static int nodeNum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		String[] firstLine = br.readLine().split(" ");
		nodeNum = Integer.parseInt(firstLine[0]);
		int edgeNum = Integer.parseInt(firstLine[1]);
		int startNode = Integer.parseInt(firstLine[2]);

		adj = new boolean[nodeNum+1][nodeNum+1];
		visited = new boolean[nodeNum+1];
		
		for(int i = 0; i<edgeNum; i++) {
			String[] edge = br.readLine().split(" ");
			int src = Integer.parseInt(edge[0]);
			int dest = Integer.parseInt(edge[1]);
			
			//double arrow
			adj[src][dest] = true;
			adj[dest][src] = true;
		}
		DFS(startNode);
		sb.append("\n");
		Arrays.fill(visited, false);
		BFS(startNode);
		bw.write(sb.toString().trim());
		bw.flush();
	}

	private static void DFS(int startNode) {
		sb.append(startNode+" ");
		visited[startNode] = true;
		for(int i = 0; i<=nodeNum; i++) {
			if(adj[startNode][i] && !visited[i]) {
				DFS(i);
			}
		}
	}
	private static void BFS(int startNode) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(startNode);
		visited[startNode] = true;
		//sb.append(startNode+" ");
		
		int num = 0;
		while(!queue.isEmpty()) {
			num = queue.poll();
			sb.append(num+" ");
			for(int i = 0; i<=nodeNum; i++) {
				if(adj[num][i] && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
}
