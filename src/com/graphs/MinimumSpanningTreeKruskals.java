package com.graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
class CoOrd implements Comparable<CoOrd>{
	int a;
	int b;
	int weight;
	@Override
	public int compareTo(CoOrd o) {
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
public class MinimumSpanningTreeKruskals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		CoOrd[] coOrdinates=new CoOrd[m];
		int[] disSet=new int[n+1];
		for(int i=1;i<disSet.length;i++) {
			disSet[i]=i;
		}
		for(int i=0;i<m;i++) {
			CoOrd coOrd=new CoOrd();
			coOrd.a=sc.nextInt();
			coOrd.b=sc.nextInt();
			coOrd.weight=sc.nextInt();
			coOrdinates[i]=coOrd;
		}
		System.out.println(getWeight(coOrdinates,disSet,n));
	}

	private static int getWeight(CoOrd[] coOrdinates, int[] disSet, int n) {
		// TODO Auto-generated method stub
		int minWeight=0;
		Arrays.sort(coOrdinates);
		for(int i=0;i<coOrdinates.length;i++) {
			//System.out.println(coOrdinates[i].weight+" ");
			if(disjoint(disSet,coOrdinates[i].a,coOrdinates[i].b)) {
				minWeight=minWeight+coOrdinates[i].weight;
				union(disSet,coOrdinates[i].a,coOrdinates[i].b);
			}
		}
		return minWeight;
	}

	private static void union(int[] disSet, int a, int b) {
		// TODO Auto-generated method stub
		while(disSet[a]!=a) {
			disSet[a]=disSet[disSet[a]];
			a=disSet[a];
		}
		while(disSet[b]!=b) {
			disSet[b]=disSet[disSet[b]];
			b=disSet[b];
		}
		disSet[a]=disSet[b];
	}

	private static boolean disjoint(int[] disSet, int a, int b) {
		// TODO Auto-generated method stub
		while(disSet[a]!=a) {
			disSet[a]=disSet[disSet[a]];
			a=disSet[a];
		}
		while(disSet[b]!=b) {
			disSet[b]=disSet[disSet[b]];
			b=disSet[b];
		}
		if(a!=b) {
			return true;
		}else {
			return false;
		}
	}

}
