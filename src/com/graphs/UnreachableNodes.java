package com.graphs;

import java.util.Scanner;
import java.util.*;

public class UnreachableNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		HashMap<Integer,ArrayList<Integer>> graph=new HashMap<Integer,ArrayList<Integer>>();
		for(int i=1;i<=n;i++) {
			graph.put(i, new ArrayList<Integer>());
		}
		for(int i=0;i<m;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			ArrayList<Integer> list1=graph.get(a);
			list1.add(b);
			ArrayList<Integer> list2=graph.get(b);
			list2.add(a);
		}
		int x=sc.nextInt();
		boolean[] visited=new boolean[n+1];
		depthFirstSearch(graph,visited,x);
		System.out.println(getUnreachableNodes(visited));
	}

	private static int getUnreachableNodes(boolean[] visited) {
		// TODO Auto-generated method stub
		int count=0;
		for(int i=1;i<visited.length;i++) {
			if(visited[i]==false) {
				count++;
			}
		}
		return count;
	}

	private static void depthFirstSearch(HashMap<Integer,ArrayList<Integer>> graph,boolean[] visited,
			int source) {
		// TODO Auto-generated method stub
		visited[source]=true;
		ArrayList<Integer> list=graph.get(source);
		for(int i=0;i<list.size();i++) {
			if(visited[list.get(i)]==false) {
				depthFirstSearch(graph,visited,list.get(i));
			}
		}
	}

}
