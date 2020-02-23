package com.backtracking;

import java.util.ArrayList;
import java.util.HashSet;

public class Boogle {
	static int[] rowCount= {0,0,-1,1,-1,1,1,-1};
	static int[] colCount= {1,-1,0,0,-1,-1,1,1};
	static ArrayList<String> dictionary=new ArrayList<String>();
	static int m=0;
	static int n=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		m=3;
		n=3;
		dictionary.add(new String("face"));
		dictionary.add(new String("book"));
		dictionary.add(new String("ace"));
		dictionary.add(new String("books"));
		dictionary.add(new String("aces"));
		char[][] matrix= {{'f','o','b'},{'o','a','e'},{'k','s','e'}};
		boolean[][] visited=new boolean[m][n];
		String word="";
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				visited[i][j]=true;
				findWords(matrix,visited,i,j,word.concat(String.valueOf(matrix[i][j])));
				visited[i][j]=false;
			}
		}
		
		
	}
	private static void findWords(char[][] matrix,boolean[][] visited,int row,int col,String word) {
		//System.out.println(word);
		//System.out.print(dictionary.size());
		if(dictionary.contains(word)) {
			System.out.println(word);
		}
		if(word.length()==m*n) {
			//System.out.println(m);
			return;
		}
		else {
			for(int i=0;i<rowCount.length;i++) {
				int rowNew=row+rowCount[i];
				int colNew=col+colCount[i];
				if(isValidMove(rowNew,colNew,visited)) {
					visited[rowNew][colNew]=true;
					findWords(matrix,visited,rowNew,colNew,word.concat(String.valueOf(matrix[rowNew][colNew])));
					visited[rowNew][colNew]=false;
				}
			}
		}
	}
	private static boolean isValidMove(int row, int col, boolean[][] visited) {
		// TODO Auto-generated method stub
		if(row>=0 && row<m && col>=0 && col<n && !visited[row][col]) {
			return true;
		}
		return false;
	}

}
