/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/28 22:18
 * @description： Leetcode 每日一题693. 交替位二进制数
 * @modified By： Alascanfu
 **/
class Solution693 {
    public boolean hasAlternatingBits(int n) {
        boolean isBit = (n & 1) == 1;
        n >>= 1;
        while (n > 0) {
            if (((n & 1) == 1) == isBit) return false;
            n >>= 1;
            isBit = !isBit;
        }
        return true;
    }
    
}
