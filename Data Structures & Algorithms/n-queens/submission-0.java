class Solution {
    int N;
    int col[];
    List<List<String>> res=new ArrayList<>();

    boolean isSafe(int row,int c){
        for(int r=0;r<row;r++){
            if(col[r]==c)return false;
            if(Math.abs(col[r]-c)==row-r)return false;
        }
        return true;
    }
    void solve(int row){
        if(row==N){
            List<String> board = new ArrayList<>();
            for(int i=0;i<N;i++){
                StringBuilder sb= new StringBuilder();
                for(int j=0;j<N;j++){
                    sb.append(col[i]==j ? 'Q' : '.');
                }
                board.add(sb.toString());
            }
            res.add(board);
            return;

        }
        for(int c=0;c<N;c++){
            if(isSafe(row,c)){
                col[row]=c;
                solve(row+1);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        N=n;
        col=new int [N];
        solve(0);
        return res;
    }
}
