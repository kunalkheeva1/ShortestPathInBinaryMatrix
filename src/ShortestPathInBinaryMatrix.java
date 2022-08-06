import java.util.*;

//triplet to track the x, y coordinate and level of them
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
    // movements of x and y tracker in all 8 directions
    static int [] dx ={-1,-1,1,-1,0,1,1,0};
    static int []dy = {-1,0,-1,1,1,1,0,-1};


    static int shortestPathInBinaryMatrix(int grid[][]){
        //if first element is wall then no movement is possible
        if(grid[0][0]==1){
            return -1;
        }
        //queue of the triplet to keep track
        Queue<Triplet> q = new LinkedList<>();
        Triplet tr = new Triplet(0,0,1);
        q.add(tr);

        //rows and columns
        int n = grid.length;
        int m = grid[0].length;

        while(!q.isEmpty()){
            //get the details of the triplet
            Triplet trip = q.remove();
            int x = trip.x;
            int y = trip.y;
            int level= trip.level;

            // if it reaches the end then return the level, level is basically count,
            //level is not referring to level of the integers but count of the travelled integers
            if(x==n-1 && y== m-1){
                return level;
            }

            // get new x and y to move thru all the 8 directions of the given element
            for(int k=0; k<8; k++){
                int nx = x +dx[k];
                int ny = y + dy[k];

                // check if it is not out of the bound, then update it with 1
                //so that it do not traverse back
                //get a new triplet then and increment the level and add it in the queue
                // and repeat until reach the answer
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
