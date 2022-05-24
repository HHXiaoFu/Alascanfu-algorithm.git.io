import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/5/10 19:04
 * @description： Heap Structure
 * @modified By： Alascanfu
 **/
public class Heap {
    static int N = 100010;
    // h[]代表堆空间
    // ph[k]代表第 k 个插入的元素所处堆中的位置下标
    // hp[k] 代表的是堆中下标为 k 的元素是第几个插入堆中的
    static int[] h ,ph , hp;
    
    // size 代表的堆的大小
    // m 代表的是当前插入的是第几个元素
    static int size , m;
    
    // init
    static void init(){
        h = new int[N];
        ph = new int[N];
        hp = new int[N];
        size = 0 ;
        m = 0;
    }
    
    static void insert(int x){
        h[++size] = x;
        ph[++m] = size;
        hp[size] = m;
        up(size);
    }
    
    static int getCnt(){
        return h[1];
    }
    
    static void deleteMin(){
        heap_swap(1,size);
        size--;
        down(1);
    }
    
    static void delete(int k ){
        k = ph[k];
        heap_swap(k,size);
        size--;
        up(k);down(k);
    }
    
    static void modify(int k , int x){
        h[ph[k]] = x;
        up(ph[k]);down(ph[k]);
    }
    
    // heap_swap
    static void heap_swap(int u1 , int u2){
        // 交换因值改变的 位置指针 以及 插入时指针
        swap(ph,hp[u1],hp[u2]);
        swap(hp,u1,u2);
        // 堆位置下标为 u1 和 u2 的值进行交换
        swap(h,u1,u2);
    }
    
    static void swap(int[]arr , int a , int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    
    static void down(int u){
        int t = u ;
        if (2 * u <= size && h[t] > h[2 * u]){
            t = 2 * u;
        }
        if (2 * u + 1 <= size && h[t] > h[2 * u + 1]){
            t = 2 * u + 1;
        }
        if (t != u){
            heap_swap(u , t);
            down(t);
        }
    }
    
    static void up(int u ){
        int t = u ;
        if (u / 2 > 0 && h[u/2] > h[t]){
            heap_swap(u/2 ,t);
            up(u/2);
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        int n = Integer.parseInt(br.readLine());
        while (n -- > 0){
            String[] params = br.readLine().split(" ");
            String operate = params[0];
            if (operate.equals("I")){
                int x = Integer.parseInt(params[1]);
                insert(x);
            }else if (operate.equals("PM")){
                System.out.println(getCnt());
            }else if (operate.equals("DM")){
                deleteMin();
            }else if (operate.equals("D")){
                int k = Integer.parseInt(params[1]);
                delete(k);
            }else if (operate.equals("C")){
                int k = Integer.parseInt(params[1]);
                int x = Integer.parseInt(params[2]);
                modify(k,x);
            }
        }
    }
}
