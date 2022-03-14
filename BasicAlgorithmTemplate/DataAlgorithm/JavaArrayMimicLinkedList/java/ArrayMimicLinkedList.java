import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/11 13:02
 * @description： 数组模拟链表
 * @modified By： Alascanfu
 **/
public class ArrayMimicLinkedList {
    static int N = 100010;
    static int head ,idx;
    static int[] e = new int [N],ne = new int[N];
    
    public static void init(){
        head = -1;
        idx = 0;
    }
    
    public static void add2Head(int val){
        e[idx] = val;
        ne[idx] = head;
        head = idx++;
    }
    
    public static void add(int k ,int val){
        e[idx] = val;
        ne[idx] = ne[k];
        ne[k] = idx++;
    }
    
    public static void remove(int k){
        ne[k] = ne[ne[k]];
    }
    
}
