package Backtracking;
import java.util.*;

//Given a N*N board with the Knight placed on the first block of an empty board. Moving according to the rules of chess knight must visit each square exactly once. Print the order of each cell in which they are visited.
public class knightsTour {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("print length of chess");
        int n=sc.nextInt();
        System.out.println("give row of chess");
        int r=sc.nextInt();
        System.out.println("give col of chess");
        int c=sc.nextInt();

        int chess[][]=new int[n][n];
        printKnightstour(chess, r, c, 0);

    }


    public static void printKnightstour(int chess[][],int r,int c,int move){

        if(r<0 || c<0 || r>=chess.length || c>=chess.length){
            return ;
        }else if(move==chess.length*chess.length){
            chess[r][c]=move;
            displayBoard(chess);
            chess[r][c]=0;
            return ;
        }

        chess[r][c]=move;
        printKnightstour(chess, r+1, c-2, move);
        printKnightstour(chess, r-2, c+1, move);
        printKnightstour(chess, r-1, c-2, move);
        printKnightstour(chess, r+2, c+1, move);
        printKnightstour(chess, r+2, c-1, move);
        printKnightstour(chess, r-2, c-1, move);
        chess[r][c]=0;
    }


    public static void displayBoard(int chess[][]){
        for(int i=0;i<chess.length;i++){
            for(int j=0;j<chess.length;j++){
                System.out.print(chess[i][j]+" ");
            }
            System.out.println();

        }
        System.out.println();
    }
    
}
