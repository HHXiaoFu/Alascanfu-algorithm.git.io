import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/5/12 18:19
 * @description： HashTableOpenAddress 开放寻址法
 * @modified By： Alascanfu
 **/
public class HashTableOpenAddress {
    static int N = getFirstPrimeNum(200000);
    static int NULL = 0x3f3f3f;
    static int[] h ;
    
    static void init(){
        h = new int[N];
        Arrays.fill(h , NULL);
    }
    
    static int find(int u){
        int k = hashCode(u);
        while (h[k] != NULL && h[k] != u){
            k++;
            if (k == N){
                k = 0;
            }
        }
        return k;
    }
    
    static int hashCode(int u){
        return (u % N + N ) % N ;
    }
    
    static int getFirstPrimeNum(int n){
        for (int i = n ; ;i++){
            boolean flag = true ;
            for (int j = 2 ; j * j <= i;j++){
                if (i % j == 0){
                    flag = false;
                }
            }
            if (flag){
                return i;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        int n = Integer.parseInt(br.readLine());
        while (n -- > 0){
            String[] params = br.readLine().split(" ");
            String op = params[0];
            if (op.equals("I")){
                int x = Integer.parseInt(params[1]);
                h[find(x)] = x;
            }else {
                int x = Integer.parseInt(params[1]);
                System.out.println(h[find(x)] == x ? "Yes" : "No");
            }
        }
    }
}
