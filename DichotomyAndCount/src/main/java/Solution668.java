/***
 * @author： Alascanfu
 * @date ： Created in 2022/5/18 11:20
 * @description： LeetCode 668. 乘法表中第k小的数
 * @modified By： Alascanfu
 **/
class Solution668 {
    int m , n ;
    int k ;
    public int findKthNumber(int m, int n, int k) {
        this.m = m ;
        this.n = n ;
        this.k = k ;
        int l = 1;
        int r = m * n ;
        while (l < r){
            int mid = l + r >> 1;
            int cnt = countLess(mid);
            if (countLess(mid) >= k ){
                r = mid ;
            }else {
                l = mid + 1;
            }
        }
        return r;
    }
    
    int countLess(int mid){
        int cnt = 0 ;
        int j = m ;
        for (int i = 1 ; i <= n ; i++){
            while (j >= 1 && i * j > mid){
                j--;
            }
            cnt += j;
        }
        return cnt ;
    }
}