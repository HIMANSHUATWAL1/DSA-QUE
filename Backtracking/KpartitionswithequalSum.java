package Backtracking;
import java.util.*;
//Partition of a set into K subsets with equal sum

//Given an integer array of N elements, the task is to divide this array into K non-empty subsets such that the sum of elements in every subset is same.
public class KpartitionswithequalSum {

  public static  boolean isKPartitionPossible(int arr[], int n, int k)
    {
	     int total=0;
	     
	     for(int i=0;i<n;i++){
	         total+=arr[i];
	     }
	     
	     if(total%k!=0) return false;
	     
	     if(n<k) return false;
	     
	     int subsetSum=total/k;
	     
	     boolean visited[]=new boolean[n];
	     
	     return canPartition(arr,visited,0,k,0,subsetSum);
	     
	     
	     
    }

    public static  boolean canPartition(int arr[],boolean visited[],int start,int k,int currSum,int subsetSum){
      if(k==0) return true;
      if(currSum>subsetSum) return false;
      
      if(currSum==subsetSum){
          return canPartition(arr,visited,0,k-1,0,subsetSum);
      }
      
      
      for(int i=start;i<arr.length;i++){
          if(visited[i]) continue;
          visited[i]=true;
          
          if(canPartition(arr,visited,i+1,k,currSum+arr[i],subsetSum)) return true;
          
          visited[i]=false;
          
      }
      return false;
      
  
  }
    




    


public static void main(String[] args) {
  int n = 5;
 int arr[] = {2,1,5,5,6};
  int k = 3;
 
  boolean ans=isKPartitionPossible(arr, n, k);
  if(ans){
    System.out.println("true");
  }else{
    System.out.println("false");
  }

    
}

}
