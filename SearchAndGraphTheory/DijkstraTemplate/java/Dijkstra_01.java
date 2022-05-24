/***
 * @author： Alascanfu
 * @date ： Created in 2022/5/22 15:25
 * @description： Dijkstra 朴素做法 时间复杂度 O(n^2)
 * @modified By： Alascanfu
 **/
import java.io.*;
import java.util.*;

class Main{
    static int n , m;
    static int N = 510 ;
    static int [][] g ;
    static int [] dist ;
    static boolean[] st ;
    static int INFTY = 10010;
    
    static void init(){
        g = new int[N][N];
        dist = new int[N];
        st = new boolean[N];
        Arrays.fill(dist,INFTY);
        for (int i = 1 ; i<= n ; i++){
            Arrays.fill(g[i],INFTY);
        }
        dist[1] = 0;
    }
    
    static int dijkstra(){
        for (int i = 1 ;i<= n ;i++){
            int t = -1 ;
            for (int j = 1 ; j<= n ; j++){
                if (!st[j] && (t == -1 || dist[t] > dist[j])){
                    t = j ;
                }
            }
            st[t] = true ;
            for (int j = 1 ; j <= n ;j++){
                dist[j] = Math.min(dist[j],dist[t] + g[t][j]);
            }
        }
        if (dist[n] == 10010){
            return -1;
        }else{
            return dist[n];
        }
    }
    
    public static void main(String[] args )throws IOException{
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        args = br.readLine().split(" ");
        n = Integer.parseInt(args[0]);
        m = Integer.parseInt(args[1]);
        init();
        while (m-- > 0){
            args = br.readLine().split(" ");
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            int z = Integer.parseInt(args[2]);
            if (x == y){
                g[x][y] = 0;
            }else {
                g[x][y] = Math.min(g[x][y] , z);
            }
        }
        System.out.print(dijkstra());
    }
}
