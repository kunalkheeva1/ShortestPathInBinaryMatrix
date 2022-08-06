import java.util.*;


class Triplet{
    int x;
    int y;
    int level;
    Triplet(int x, int y, int level){
        this.x =x;
        this.y = y;
        this.level = level;
    }
}



public class ShortestPathInBinaryMatrix {
    static int [] dx ={-1,-1,1,-1,0,1,1,0};
    static int []dy = {-1,0,-1,1,1,1,0,-1};

    static int shortestPathInBinaryMatrix(int grid[][]){
        if(grid[0][0]==1){
            return -1;
        }
        Queue<Triplet> q = new LinkedList<>();
        Triplet tr = new Triplet(0,0,1);
        q.add(tr);

        int n = grid.length;
        int m = grid[0].length;

        while(!q.isEmpty()){
            Triplet trip = q.remove();
            int x = trip.x;
            int y = trip.y;
            int level= trip.level;

            if(x==n-1 && y== m-1){
                return level;
            }
            for(int k=0; k<8; k++){
                int nx = x +dx[k];
                int ny = y + dy[k];

                if(nx<n && ny<m && nx>0 && ny>0 && grid[nx][ny]==0 ){
                    grid[nx][ny]=1;
                    Triplet ntr = new Triplet(nx,ny, level+1);
                    q.add(ntr);
                }
            }
        }
            return -1;



    }


    public static void main(String[] args) {

    }
}
