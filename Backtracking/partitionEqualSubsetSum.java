package Backtracking;
import java.util.*;

public class partitionEqualSubsetSum {
 
public static int equalPartition(int n,int arr[]){
    int total=0;

    for(int i=0;i<n;i++){
        total+=arr[i];
    }
  
    if(total%2!=0)return 0;
    
    int target=total/2;


    int dp[][]=new int[n][target+1];

    for(int i=0;i<n;i++){
        for(int j=0;j<=target;j++){
            dp[i][j]=-1;
        }
    }

    return solve(arr,n,0,target,dp)?1:0;

}

static boolean solve(int arr[], int n, int index, int target, int dp[][]) {
    if (target == 0) {
        return true;
    }

    if (index >= n || target < 0) {
        return false;
    }

    if (dp[index][target] != -1) {
        return dp[index][target] == 1;
    }

    boolean include = solve(arr, n, index + 1, target - arr[index], dp);
    boolean exclude = solve(arr, n, index + 1, target, dp);

    dp[index][target] = (include || exclude) ? 1 : 0;

    return dp[index][target] == 1;
}




    public static void main(String[] args) {
        int arr[]={1, 5, 11, 5};
        int n=4;
        int ans=equalPartition(n, arr);
     System.out.println(ans);
    }
    
}
