package Backtracking;
import java.util.*;
public class WordBreakProblem {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("enter length of sentence");
        int n=sc.nextInt();
        HashSet<String>dict=new HashSet<>();
        System.out.println("enter your words");
        for(int i=0;i<n;i++){
            dict.add(sc.next());
        }
      System.out.println("enter your sentence");
        String sentence=sc.next();
        System.out.println("here is your answers:--");
        wordBreak(sentence,"",dict);
    }


    public static void wordBreak(String str,String ans,HashSet<String>dict){
        if(str.length()==0){
            
            System.out.println(ans);
            return;
        }

        for(int i=0;i<str.length();i++){
            String left=str.substring(0, i+1);
            if(dict.contains(left)){
                String right=str.substring(i+1);
                wordBreak(right, ans+left+" ", dict);
            }
        }
    }
}
