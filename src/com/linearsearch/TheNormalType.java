package com.linearsearch;

import java.util.*;
class TheNormalType {
    public static void main(String args[] ) throws Exception {
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      long[] a=new long[n];
      HashSet<Long> distinctSet=new HashSet<Long>();//For counting the distinct elements from array
      for(int i=0;i<n;i++){
          a[i]=sc.nextInt();
          distinctSet.add(a[i]);
      }
      int noOfDistinct=distinctSet.size();
      int loopTerm=n-noOfDistinct;
      long allPossibleArrays=0;
      HashMap<Long,Integer> track=new HashMap<Long,Integer>();//For tracking the repetition of elements
      int i=0;int j=i+1;track.put(a[i],1);
      for(;i<=loopTerm;i++){
          while(j<n && track.size()<noOfDistinct){
              if(track.containsKey(a[j])){
                  track.put(a[j],track.get(a[j])+1);
              }else{
                  track.put(a[j],1);
              }
              j++;
          }
          if(track.size()==noOfDistinct){//if size of track matches distinct then we found the solution
              allPossibleArrays=allPossibleArrays+n-j+1;//n-j+1 will give actual number of sets
              if(track.get(a[i])>1){
                  track.put(a[i],track.get(a[i])-1);//reducing the count for i th element
              }else{
                  track.remove(a[i]);//removing the ith element from the track
              }
          }
      }
      System.out.println(allPossibleArrays);
      sc.close();
    }
}
