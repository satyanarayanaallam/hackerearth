package com.backtracking;

public class PermutationsOfStringHavingDistinct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] input= {'a','b','c'};
		char[] result= new char[3];
		int[] count= {1,1,1};
		printAllpermutations(input,result,count,0);
	}
	private static void printAllpermutations(char[] input,char[] result,int[] count,int level) {
		if(level==input.length) {
			for(int i=0;i<result.length;i++) {
				System.out.print(result[i]);
			}
			System.out.println();
			return ;
		}
		else {
			for(int i=0;i<input.length;i++) {
				if(count[i]==0) {
					continue;
				}else {
					result[level]=input[i];
					count[i]--;
					level++;
					printAllpermutations(input,result,count,level);
					count[i]++;
					level--;
				}
				
			}
			
		}
		
	}
}
