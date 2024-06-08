package Backtracking;
// ans is not comming.
import java.util.*;

public class kPartitions {

    public static void solution(int i, int n, int k, int noSet, ArrayList<ArrayList<Integer>> ans) {
        // base case-->
        if (i > n) {
            if (noSet == k) {
                for (ArrayList<Integer> set : ans) {
                    System.out.println(set + " ");
                }
                System.out.println();
            }
            return;
        }

        for (int j = 0; j < ans.size(); j++) {
            // if partition is already nonempty so we add our value to any one of these
            // partitions.
            if (ans.get(j).size() > 0) {
                ans.get(j).add(i);
                solution(i + 1, n, k, noSet, ans);
                ans.get(j).remove(ans.get(j).size() - 1);
            } else {
                // if any partition is empty-->
                ans.get(j).add(i);
                solution(i+1 , n, k, noSet + 1, ans); // here partition increases by 1 because previously it is empty.
                ans.get(j).remove(ans.get(j).size() - 1);
                break;

            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter your num:");
        int n=sc.nextInt();
        System.out.println("enter no. of set you wants:");
        int k=sc.nextInt();
        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
        for(int i=0;i<k;i++){
            ans.add(new ArrayList<>());
        }
      solution(1, n, k, 0, ans);
    }

}
