/***
 * @author： Alascanfu
 * @date ： Created in 2022/5/14 11:24
 * @description： HeapSort 实现
 * @modified By： Alascanfu
 **/
class SolutionHeapSort implements SortInterface {
    static int N ;
    static int[] h = new int[N+10];
    static int size ;
    
    static void swap( int i , int j ){
        int tmp = h[i];
        h[i] = h[j];
        h[j] = tmp;
    }
    
    static void down(int u ){
        int t = u ;
        if (2 * u <= size && h[2 * u] < h[t]){
            t = 2 * u ;
        }
        if (2 * u + 1 <= size && h[2 * u + 1] < h[t]){
            t = 2 * u + 1;
        }
        if (t != u){
            swap(t,u);
            down(t);
        }
    }
    static void DM(){
        h[1] = h[size--];
        down(1);
    }
    
    static int GM(){
        return h[1];
    }
    
    static void build(){
        for (int i = (N - 10) / 2 ; i > 0 ; i --){
            down(i);
        }
    }
    
    @Override
    public int[] sort(int[] arr) {
        N = arr.length + 10;
        int[] res = new int[arr.length];
        int idx = 0 ;
        for (int i = 1 ; i <= arr.length;i++){
            h[i] = arr[i-1];
        }
        size = arr.length;
        build();
        for (int i = 0 ; i< N - 10;i++){
            res[idx++] = GM();
            DM();
        }
        return res;
    }
}
