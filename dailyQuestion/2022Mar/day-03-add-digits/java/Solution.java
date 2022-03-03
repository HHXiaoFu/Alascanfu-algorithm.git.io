/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/3 12:28
 * @description： LeetCode 每日一题. 258各位相加 2022/03/03
 * @modified By： Alascanfu
 **/
class Solution258 {
    /**
     * 递归实现
     */
    public int addDigits(int num) {
        // 递归结束终止条件 当num 为各位时直接返回
        if (num < 10) return num;
        // 每次只需要递归求解 各位相加的数
        else return addDigits(num % 10 + num / 10);
    }
    
    public int addDigits2(int num) {
        int res = 0;
        while (num > 0){
            res += num % 10;
            num /= 10;
        }
        
        while (res > 10){
            res = res%10 + res/10;
        }
        return res;
    }
    
    public int addDigits3(int num){
        if (num > 9){
            if (num % 9 == 0)return 9;
            return num % 9;
        }
        return num;
    }
}
