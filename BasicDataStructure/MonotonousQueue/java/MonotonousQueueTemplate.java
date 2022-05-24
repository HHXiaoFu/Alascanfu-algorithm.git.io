import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/4/27 20:48
 * @description： MonotonousQueueTemplate
 * @modified By： Alascanfu
 **/
public class MonotonousQueueTemplate {
    static int N = 1000010;
    static int[] a, q;
    static int hh ,tt;
    static void init() {
        a = new int[N] ;
        q = new int[N] ;
        hh = 0 ;
        tt = -1;
    }
    
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        init();
        String[] params = br.readLine().split(" ");
        int n = Integer.parseInt(params[0]);
        int k = Integer.parseInt(params[1]);
        String[] params1 = br.readLine().split(" ");
        for (int i = 0 ; i< n ;i++){
            a[i] = Integer.parseInt(params1[i]);
        }
        for (int i = 0 ; i< n ;i++){
            // 判断队头是否已经滑出窗口
            if (hh <= tt && i - k + 1 > q[hh]) hh++;
            while (hh <= tt && a[q[tt]] >= a[i])tt--;
            q[++ tt] = i ;
            if (i > k - 1) System.out.print(a[q[hh]]);
        }
    }
    
}
