/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/5 9:46
 * @description： Leetcode每日一题521.最长特殊序列1 2022/03/05
 * @modified By： Alascanfu
 **/
class Solution521 {
    // 简单的脑筋急转弯
    public int findLUSlength(String a, String b) {
        int n = a.length(),m = b.length();
        if (m == n)return a.equals(b) ? -1 : m;
        return Math.max(m,n);
    }
}
