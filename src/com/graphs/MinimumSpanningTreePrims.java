package com.graphs;

import java.util.*;
class WeightComparator implements Comparator<Vertex>{

	@Override
	public int compare(Vertex o1, Vertex o2) {
		// TODO Auto-generated method stub
		if (o1.weight < o2.weight) 
            return -1; 
        else if (o1.weight > o2.weight) 
            return 1; 
                        return 0; 
	}
	
}
class Vertex implements Comparable<Vertex>{
	int weight;
	int v;
	@Override
	public int compareTo(Vertex o) {
		// TODO Auto-generated method stub
		if(this.weight==o.weight) {
			return 0;
		}else if(this.weight>o.weight) {
			return 1;
		}else {
			return -1;
		}
	}
}
public class MinimumSpanningTreePrims {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		HashMap<Integer,ArrayList<Vertex>> graph=new HashMap<Integer,ArrayList<Vertex>>();
		for(int i=1;i<=n;i++) {
			graph.put(i, new ArrayList<Vertex>());
		}
		for(int i=0;i<m;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int w=sc.nextInt();
			ArrayList<Vertex> list1=graph.get(a); 
			Vertex vertex=new Vertex();
			vertex.v=b;vertex.weight=w;
			list1.add(vertex);
			ArrayList<Vertex> list2=graph.get(b); 
			Vertex vertex2=new Vertex();
			vertex2.v=a;vertex2.weight=w;
			list2.add(vertex2);
		}
		System.out.println(prims(1,graph));
	}

	private static int prims(int i, HashMap<Integer, ArrayList<Vertex>> graph) {
		// TODO Auto-generated method stub
		int minCost=0;
		//PriorityQueue<Vertex> q=new PriorityQueue<Vertex>(graph.size(),new WeightComparator());
		PriorityQueue<Vertex> q=new PriorityQueue<Vertex>();
		boolean visited[]=new boolean[graph.size()+1];
		Vertex v=new Vertex();
		v.weight=0;v.v=i;
		q.add(v);
		while(!q.isEmpty()){
			Vertex p=q.peek();
			q.remove();
			//System.out.println(p.v+"  "+p.weight);
			if(visited[p.v]==true) 
				continue;
			
				visited[p.v]=true;
				minCost=minCost+p.weight;
				for(int j=0;j<graph.get(p.v).size();j++) {
					Vertex y=graph.get(p.v).get(j);
					if(visited[y.v]==false) {
						q.add(y);
					}
				}
			
		}
		return minCost;
	}

}
