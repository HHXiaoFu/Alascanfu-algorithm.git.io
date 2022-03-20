import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/20 15:48
 * @description： OneDimensionDifferenceTemplate 一维差分计算模板公式
 * @modified By： Alascanfu
 **/
public class DifferenceTemplate {
    static int N = 100010;
    static int[] a;
    static int[] b;
    
    static void init(){
        a = new int[N];
        b = new int[N];
    }
    
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        init();
        String[] params1 = br.readLine().split(" ");
        int n = Integer.parseInt(params1[0]);
        int m = Integer.parseInt(params1[1]);
        String[] params2 = br.readLine().split(" ");
        for (int i = 1 ; i<= n;i++){
            a[i] = Integer.parseInt(params2[i-1]);
        }
        
        for (int i = 1;i<= n;i++){
            b[i] = a[i] - a[i-1];
        }
        
        while (m-- > 0){
            String[] params3 = br.readLine().split(" ");
            int l = Integer.parseInt(params3[0]);
            int r = Integer.parseInt(params3[1]);
            int c = Integer.parseInt(params3[2]);
            b[l] += c;
            b[r+1] -= c;
        }
        
        for (int i = 1;i<=n;i++){
            a[i] = b[i] + a[i-1];
            System.out.print(a[i] + " ");
        }
    }
}
