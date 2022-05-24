import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/5/22 16:37
 * @description： Dijkstra 堆优化版做法 时间复杂度通常为 O(m*log_n)
 * @modified By： Alascanfu
 **/
public class Dijkstra_02 {
    static int N = 1000010 ;
    static int M = 2 * N ;
    /** INFTY 的 distance 必须大于 N * 10000 */
    static int INFTY = 0x3f3f3f3f;
    static int n , m ;
    static int[] h , e , ne , w ;
    static int idx ;
    static PriorityQueue<int[]> pq;
    static int[] dist ;
    static boolean[] st ;
    
    static void init(){
        h = new int[N];
        e = new int[M];
        ne = new int[M];
        w = new int[N];
        idx = 0 ;
        Arrays.fill(h,-1);
        pq = new PriorityQueue<>((a,b)->{
            return a[1] - b[1];
        });
        dist = new int[N];
        st = new boolean[N];
    }
    
    static int dijkstra(){
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            int t = cur[0] ,distance = cur[1];
            if (st[t]){
                continue;
            }
            st[t] = true ;
            for (int i = h[t] ; i != -1 ; i = ne[i]) {
                int j = e[i];
                if (dist[j] > distance + w[i]) {
                    dist[j] = distance + w[i];
                    pq.offer(new int[]{j, dist[j]});
                }
            }
        }
        return dist[n] == INFTY ? -1 : dist[n];
    }
    
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        args = br.readLine().split(" ");
        n = Integer.parseInt(args[0]);
        m = Integer.parseInt(args[1]);
        // 因为是一个稀疏图 所以采用邻接表存储
        init();
        while (m -- > 0 ){
            args = br.readLine().split(" ");
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int c = Integer.parseInt(args[2]);
            add(a,b,c);
        }
        Arrays.fill(dist,INFTY);
        dist[1] = 0 ;
        pq.offer(new int[]{1, 0 });
        System.out.println(dijkstra());
    }
    
    static void add(int a, int b, int c) {
        e[idx] = b ; w[idx] = c ; ne[idx] = h[a] ; h[a] = idx++;
    }
}
