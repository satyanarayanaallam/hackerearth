package com.backtracking;

public class KnightTour {
	static int m = 0;
	static int n = 0;
	static int[] rowCount= {-2,-1,1,2,2,1,-1,-2};
	static int[] colCount= {1,2,2,1,-1,-2,-2,-1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		m = 8;
		n = 8;
		int[][] visited= {
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0}
		};
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				visited[i][j]=1;
				printKnightTour(visited,i,j,1);
				visited=new int[m][n];
			}
		}
		
	
	}

	private static boolean printKnightTour(int[][] visited, int row, int col, int move) {
		if (move ==m*n) {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(visited[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("------------------------");
			return true;
		}
		else {
			for(int i=0;i<rowCount.length;i++) {
				int rowNew=row+rowCount[i];
				int colNew=col+colCount[i];
				if(isSafe(rowNew,colNew,visited)) {
					move++;
					visited[rowNew][colNew]=move;
					if(printKnightTour(visited,rowNew,colNew,move)) {
						return true;
					}
					move--;
					visited[rowNew][colNew]=0;
				}
						
			}
			
		}
		return false;
	}

	private static boolean isSafe(int rowNew, int colNew, int[][] visited) {
		// TODO Auto-generated method stub
		if(rowNew>=0 && rowNew<m && colNew>=0 && colNew<n && visited[rowNew][colNew]==0) {
			return true;
		}
		return false;
	}
}
