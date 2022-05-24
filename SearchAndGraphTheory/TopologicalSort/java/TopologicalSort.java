import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/5/18 21:43
 * @description： TopologicalSort 拓扑排序 解决有向图的拓扑序列
 * @modified By： Alascanfu
 **/
class Main {
    static int N = 100010;
    static int M = 2 * N ;
    // 邻接表 记录
    static int[] h , e , ne ;
    static int idx ;
    // 队列
    static Deque<Integer> dq ;
    // d[i] 用于记录i点 的入度
    static int[] d ;
    
    static int cnt ;
    static int[] top ;
    
    static void init(){
        idx = 0 ;
        h = new int[N];
        e = new int[M];
        ne = new int[M];
        d = new int[N];
        cnt = 0 ;
        dq = new ArrayDeque<>();
        top = new int[N];
        Arrays.fill(h,-1);
    }
    
    // 建 边
    static void add(int a , int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
    }
    
    static boolean topologicalSort(int n ){
        while (!dq.isEmpty()){
            int u = dq.poll();
            for (int i = h[u] ; i != -1 ; i = ne[i]){
                int j = e[i];
                d[j] --;
                if (d[j] == 0){
                    dq.offer(j);
                    top[cnt ++] = j;
                }
            }
        }
        return cnt == n;
    }
    
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        init();
        args = br.readLine().split(" ");
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        while (m-- > 0){
            args = br.readLine().split(" ");
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            add(x,y);
            d[y] ++ ;
        }
        
        for (int i = 1 ; i <= n ; i++){
            if (d[i] == 0){
                dq.offer(i);
                top[cnt++] = i;
            }
        }
        
        if (topologicalSort(n)){
            for (int i = 0 ; i< n ; i++){
                System.out.println(top[i]);
            }
        }else {
            System.out.print(-1);
        }
    }
}
