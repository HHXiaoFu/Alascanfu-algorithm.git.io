import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/5/16 13:11
 * @description： BFSTemplate 走迷宫例题
 * @modified By： Alascanfu
 **/
class Pair{
    int x ;
    int y ;
    Pair(int x , int y){
        this.x = x ;
        this.y = y ;
    }
}

public class BFSTemplate {
    static Deque<int[]> dq ;
    static int[][] map ;
    static int[][] d ;
    static Pair[][] prev ;
    static int[][] directions ;
    static int n , m;
    static void init(int n , int m){
        dq = new ArrayDeque<>();
        map = new int[n][m];
        d = new int[n][m];
        prev = new Pair[n][m];
        directions = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    }
    
    static int bfs (){
        while (!dq.isEmpty()){
            int[] point = dq.poll();
            int x = point[0];
            int y = point[1];
            for (int[] dir : directions){
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX < 0 || newY < 0 || newX >= n || newY >= m ||
                    map[newX][newY] != 0 || d[newX][newY] != 0){
                    continue;
                }
                d[newX][newY] = d[x][y] + 1;
                dq.offer(new int[]{newX , newY});
                prev[newX][newY] = new Pair(x , y);
            }
        }
    
        int x = n - 1,y = m -1;
        while (!(x == 0 && y == 0)){
            System.out.println(x+ " " + y);
            Pair tmp = prev[x][y];
            x = tmp.x;
            y = tmp.y;
        }
        return d[n-1][m-1];
    }
    
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String[] params = br.readLine().split(" ");
        n = Integer.parseInt(params[0]);
        m = Integer.parseInt(params[1]);
        init(n,m);
        for (int i = 0 ; i < n ; i++){
            params = br.readLine().split(" ");
            for (int j = 0 ; j < m ; j++){
                map[i][j] = Integer.parseInt(params[j]);
            }
        }
        dq.offer(new int[]{0,0});
        System.out.println(bfs());
    }
}

