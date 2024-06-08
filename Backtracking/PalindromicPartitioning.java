package Backtracking;
import java.util.*;

/**
 * PalindromicPartitioning
 */

 // find all possible palindromic partitions of a given string.

public class PalindromicPartitioning {
  
    public static boolean isPalindromic(String str){
        int l=0;
        int r=str.length()-1;
        while (l<r) {
            char left=str.charAt(l);
            char right=str.charAt(r);
            if(left!=right){
                return false;
            }
        l++;
        r--;
            
        }

        return true;
    }


    public static void solution(String str,String ans){
        if(str.length()==0){
           System.out.println(ans);
           return ;
        }

        for(int i=0;i<str.length();i++){
         String prifix=str.substring(0, i+1);
         String rest=str.substring(i+1);
         if(isPalindromic(prifix)){
            solution(rest, ans+"("+prifix+")");
         }

        }
    }


    public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      System.out.println("enetr your string");
      String str=sc.nextLine();
         solution(str, "");

        
    }

    
}