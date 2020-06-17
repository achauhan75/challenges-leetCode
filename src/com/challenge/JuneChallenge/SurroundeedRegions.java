package com.challenge.JuneChallenge;

public class SurroundeedRegions {
    boolean[][] notToBeFlipped;   // will have values true if that position is not to be flipped after applying the algorithm.
    boolean[][] visited; // will store true value for a position if it gets visited in the algorithm.

    public void searchConnectedZero(char[][] board, int i, int j){
        if(i>=board.length || j>=board[0].length || i<0 ||j<0){
            //outside the board
            return;
        }
        if(board[i][j]=='X' || board[i][j]=='x'){
            //not to proceed if it is an X
            return;
        }
        // now the value is 0 and it is inside the board.
        if(visited[i][j]){
            //get out of a potential loop
            //in case of something like 0 0
            //                          0 0
            //this situation somewhere inside the matrix
            return;
        }
        visited[i][j]=true;
        notToBeFlipped[i][j]=true;
        //go left right up and down;
        searchConnectedZero(board,i+1,j);
        searchConnectedZero(board,i-1,j);
        searchConnectedZero(board,i,j+1);
        searchConnectedZero(board,i,j-1);
    }

        public void solve(char[][] board) {
        if(board.length==0){
            //if they put in a naughty testcase to make you feel frustrated xD
            return;
        }
        notToBeFlipped=new boolean[board.length][board[0].length]; //initialization
        visited= new boolean[board.length][board[0].length];// initialization
        for(int i=0;i<board.length;i++){
            //Visit the boundaries of the matrix only and start a dfs from every value
            if(!visited[i][0]){
                notToBeFlipped[i][0]=true;
                searchConnectedZero(board,i,0);
            }
            if(!visited[i][board[0].length-1]){
                notToBeFlipped[i][board[0].length-1]=true;
                searchConnectedZero(board,i,board[0].length-1);
            }

            // The try and catch block are used to handle exceptions for the case of the matrices
            // which have n x m dimension where n!=m

            try{
                if(!visited[0][i]){
                    notToBeFlipped[0][i]=true;
                    searchConnectedZero(board,0,i);
                }
            }
            catch(Exception e){
                //do nothing
                //just for a non square matrix
            }
            try{
                if(!visited[board.length-1][i]){
                    notToBeFlipped[board.length-1][i]=true;
                    searchConnectedZero(board,board.length-1,i);
                }
            }
            catch(Exception e){
                //do nothing
                //just for a non square matrix
            }
        }

        //now flip the places that are false in notToBeFlipped matrix
        //the loop doesn't run on the boundary elements :)
        for(int i=1;i<board.length-1;i++){
            for(int j=1;j<board[0].length-1;j++){
                if(!notToBeFlipped[i][j]){
                    board[i][j]='X';
                }
            }
        }
    }
}
