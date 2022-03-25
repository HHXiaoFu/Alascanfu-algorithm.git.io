/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/25 22:36
 * @description： Leetcode每日一题 172.阶乘后的零
 * @modified By： Alascanfu
 **/
class Solution172 {
    /** 方法一：暴力求取每个数中能被五整除时五的个数*/
    public int trailingZeroes(int n) {
        int cnt = 0 ;
        for (int i = 1; i<= n;i++){
            int curNum = i;
            while(curNum > 0){
                if (curNum % 5 == 0){
                    cnt++;
                    curNum/=5;
                }else {
                    break;
                }
            }
        }
        return cnt;
    }
    
    /**巧妙求5的个数*/
    public int trailingZeroes1(int n) {
        int cnt = 0 ;
        while(n > 0){
            cnt += n / 5;
            n/=5;
        }
        return cnt;
    }
}
