import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/5/18 17:05
 * @description： 树的重心
 * @modified By： Alascanfu
 **/
public class GravityCenterOfTree {
    static int N = 100010;
    static int M = 2 * N ;
    static int[] h , e , ne;
    static int idx ;
    static boolean[] st;
    static int res ;
    static int n ;
    
    static void init(){
        h = new int[N];
        e = new int[M];
        ne = new int[M];
        idx = 0;
        res = N ;
        st = new boolean[N];
        Arrays.fill(h,-1);
    }
    
    static void add(int a , int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
    }
    
    static int dfs (int u ){
        st[u] = true ;
        int sum = 1 , ans = 0 ;
        for (int i = h[u] ; i != -1 ;i = ne[i]){
            if (!st[e[i]]){
                int s = dfs(e[i]);
                ans = Math.max(s,ans);
                sum += s;
            }
        }
        ans = Math.max(ans , n - sum);
        res = Math.min(res, ans );
        return sum ;
    }
    
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        init();
        n = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < n - 1 ; i++){
            args = br.readLine().split(" ");
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            add(a,b);add(b,a);
        }
        dfs(1);
        System.out.println(res);
    }
}
