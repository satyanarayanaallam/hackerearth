package com.backtracking;

public class RatInaMaze {
	static int m=0;
	static int n=0;
	static int[] rowCount= {0,-1,0,1};
	static int[] colCount= {1,0,-1,0};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		m=4;
		n=4;
		int[][] maze= {
				{1,1,0,1},
				{0,1,1,1},
				{0,1,0,1},
				{0,1,1,1}
		};
		int[][] visited= {
				{0,0,0,0},	
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0},
		};
		visited[0][0]=1;
		findPath(maze,visited,0,0,1);
	}
	private static void findPath(int[][] maze,int[][] visited,int row,int col,int move) {
		if(row==m-1 && col==n-1) {
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(visited[i][j]+" ");
				}
				System.out.println();
			}
			return ;
		}
		else {
			for(int i=0;i<rowCount.length;i++) {
				int rowNew=row+rowCount[i];
				int colNew=col+colCount[i];
				if(isSafe(rowNew,colNew,visited,maze)) {
					move++;
					visited[rowNew][colNew]=move;
					findPath(maze,visited,rowNew,colNew,move);
					move--;
					visited[rowNew][colNew]=0;
				}
			}
		}
		
	}
	private static boolean isSafe(int rowNew, int colNew, int[][] visited,int[][] maze) {
		// TODO Auto-generated method stub
		if(rowNew>=0 && rowNew<m && colNew>=0 && colNew<n && visited[rowNew][colNew]==0 && maze[rowNew][colNew]==1 ) {
			return true;
		}
		return false;
	}

}
