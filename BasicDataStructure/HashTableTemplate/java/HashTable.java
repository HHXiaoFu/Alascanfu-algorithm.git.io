import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/5/12 18:05
 * @description： HashTable 拉链法
 * @modified By： Alascanfu
 **/
public class HashTable {
    static int N = getFirstPrimeNum(100000);
    static int[] h , e , ne;
    static int idx ;
    
    static void init(){
        h = new int[N];
        e = new int[N];
        ne= new int[N];
        Arrays.fill(h,-1);
        idx = 0;
    }
    
    static void add(int u ){
        int k = hashCode(u);
        e[idx] = u;
        ne[idx] = h[k];
        h[k] = idx ++;
    }
    
    static boolean contains(int u){
        int k = hashCode(u);
        for (int i = h[k] ; i != -1 ; i = ne[i]){
            if (e[i] == u){
                return true;
            }
        }
        return false;
    }
    
    static int hashCode(int u ){
        return (u % N + N ) % N;
    }
    static int getFirstPrimeNum(int n ){
        for (int i = n ; ; i++){
            boolean flag = true;
            for (int j = 2 ; j * j <= i;j++){
                if (i % j == 0){
                    flag = false;
                    break;
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
                add(x);
            }else {
                int x = Integer.parseInt(params[1]);
                System.out.println(contains(x) ? "Yes" : "No");
            }
        }
    }
}
