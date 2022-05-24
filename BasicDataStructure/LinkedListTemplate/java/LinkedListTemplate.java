import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/4/25 19:19
 * @description： LinkedListTemplate
 * @modified By： Alascanfu
 **/
public class LinkedListTemplate {
    static int N = 100010 ;
    static int[] e , ne ;
    static int idx , head ;
    
    static void init() {
        e = new int[N];
        ne = new int[N];
        idx = 0 ;
        head = -1 ;
    }
    
    static void insertToHead(int val){
        e[idx] = val;
        ne[idx] = head ;
        head = idx ++;
    }
    
    static void delete(int k ){
        ne[k] = ne[ne[k]];
    }

    static void insert(int k , int val){
        e[idx] = val;
        ne[idx] = ne[k];
        ne[k] = idx ++;
    }
    
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        init();
        int m = Integer.parseInt(br.readLine());
        while (m -- > 0){
            String[] params = br.readLine().split(" ");
            String operation = params[0];
            if(operation.equals("H")){
                int x = Integer.parseInt(params[1]);
                insertToHead(x);
            }else if (operation.equals("D")){
                int k = Integer.parseInt(params[1]);
                if (k == 0 ){
                    head = ne[head];
                }else {
                    delete(k-1);
                }
            }else {
                int k = Integer.parseInt(params[1]);
                int x = Integer.parseInt(params[2]);
                insert(k-1 , x);
            }
        }
        
        for(int i = head ; i != -1 ; i = ne[i]){
            System.out.print(e[i] + " ");
        }
        
    }
    
}
