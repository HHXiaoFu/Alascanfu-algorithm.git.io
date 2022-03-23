/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/23 17:18
 * @description： LeetCode 每日一题 440字典序第K小数字
 * @modified By： Alascanfu
 **/
class Solution440 {
    public int findKthNumber(int n, int k) {
        int p = 1;
        int prefix = 1;
        while (p < k){
            int cnt = getCnt(n,prefix);
            if (p + cnt > k){
                prefix *=10;
                p++;
            }else if (p + cnt <= k){
                prefix ++;
                p+=cnt;
            }
        }
        return prefix;
        
    }
    
    int getCnt(int n,int prefix){
        int curPrefix = prefix;
        int nextPrefix = prefix + 1;
        int cnt = 0 ;
        while (curPrefix <= n){
            cnt += Math.min(n+1,nextPrefix) - curPrefix;
            curPrefix*=10;
            nextPrefix*=10;
        }
        return cnt;
    }
}
