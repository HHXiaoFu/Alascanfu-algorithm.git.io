import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/9 23:32
 * @description： PrefixSumTemplate
 * @modified By： Alascanfu
 **/
public class PrefixSumTemplate {
    
    static int N = 100010;
    static int[] S, a;
    
    static void init() {
        S = new int[N];
        a = new int[N];
    }
    
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        init();
        
        String[] params1 = br.readLine().split(" ");
        int n = Integer.parseInt(params1[0]);
        int m = Integer.parseInt(params1[1]);
        String[] params2 = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(params2[i - 1]);
        }
        
        for (int i = 1; i <= n; i++) {
            S[i] = S[i - 1] + a[i];
        }
        while (m-- > 0) {
            String[] params3 = br.readLine().split(" ");
            int l = Integer.parseInt(params3[0]);
            int r = Integer.parseInt(params3[1]);
            int sum = S[r] - S[l - 1];
            System.out.println(sum);
        }
    }
    
    
}
