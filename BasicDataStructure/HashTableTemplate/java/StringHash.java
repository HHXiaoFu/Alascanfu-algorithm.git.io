import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/5/12 18:27
 * @description： String Hash 字符串哈希
 * @modified By： Alascanfu
 **/
public class StringHash {
    static int N = 100010 ;
    // 用于规避 哈希冲突
    static int P = 131;
    // 用于存储字符串
    static char[] str ;
    static long[] h , p;
    static void init(){
        str = new char[N];
        h = new long[N];
        p = new long[N];
    }
    
    static void initCharArr(String s){
        for (int i = 1 ; i<= s.length();i++){
            str[i] = s.charAt(i - 1);
        }
    }
    
    static boolean checkIsEquals(int l1 , int r1 ,int l2 , int r2 ){
        return h[r1] - h[l1 - 1] * p[r1 - l1 + 1] == h[r2] - h[l2 - 1] * p[r2 - l2 + 1];
    }
    
    public static void main(String[] args) throws IOException {
        init();
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String[] params = br.readLine().split(" ");
        int n = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);
        String s = br.readLine();
        initCharArr(s);
        p[0] = 1;
        for (int i = 1 ; i <= n ; i++){
            p[i] = p[i - 1] * P;
            h[i] = h[i - 1] * P + str[i];
        }
        while(m-- > 0){
            params = br.readLine().split(" ");
            int l1 = Integer.parseInt(params[0]);
            int r1 = Integer.parseInt(params[1]);
            int l2 = Integer.parseInt(params[2]);
            int r2 = Integer.parseInt(params[3]);
            System.out.println(checkIsEquals(l1,r1,l2,r2) ? "Yes" : "No");
        }
    }
}
