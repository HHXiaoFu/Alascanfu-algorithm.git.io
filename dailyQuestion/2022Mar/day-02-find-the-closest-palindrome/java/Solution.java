/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/2 15:22
 * @description： Leetcode每日一题—— 2022/03/02. 564. 寻找最近的回文数
 * @modified By： Alascanfu
 **/
class Solution564 {
    public String nearestPalindromic(String n) {
        int lenth = n.length();
        // 特判1: 如果输入的数长度 为 1 则直接返回 n-1 的值
        if (lenth == 1) return String.valueOf(Integer.parseInt(n) - 1);
        // 特判2: 如果输入的数值为 10的幂 如 10、100、1000 ... / 11、101、1001 ...
        // 其返回值为 10的幂 - 1
        // 因为这里n给的是 10^18 所以用long进行操作
        long curNum = Long.parseLong(n);
        long powOfTen = (long) Math.pow(10, lenth - 1);
        if (curNum == powOfTen || curNum == powOfTen + 1) return String.valueOf(powOfTen - 1L);
        // 特判3: 如果输入的数值为 99、199、1999 ...
        // 则返回的是 当前值 + 2
        // powOfTen * 10L - 1L 代表的就是临界 假如为 77 => 临界 99 | 99 => 临界99
        if (curNum == powOfTen * 10L - 1L) {
            return String.valueOf(curNum + 2L);
        }
        long diff = Long.MAX_VALUE;
        long res = Long.MAX_VALUE;
        // 我们将数字分为左右两段数字 a \ b
        // 如果当前为奇数个则多为 a 分一个 需要注意的是奇数个时需要拼接反转的字符需要忽略a段的最后一个数字
        long a = Long.parseLong(n.substring(0, (lenth + 1) / 2));
        // 利用 a-1 | a | a+1 构建回文数 获取与当前值最小差值的回文串数字 利用滚动变量diff、res分别记录差值和结果
        for (int i : new int[]{-1, 0, 1}) {
            String aa = (a + i) + "";
            // 将字符串进行对应的拼接
            String curResStr = new StringBuilder(lenth % 2 == 1 ? aa.substring(0, aa.length() - 1) : aa).reverse().insert(0, aa).toString();
            if (n.equals(curResStr)) continue;
            if (Math.abs(Long.parseLong(curResStr) - curNum) <= diff) {
                diff = Math.abs(Long.parseLong(curResStr) - curNum);
                res = Math.min(res, Long.parseLong(curResStr));
            }
        }
        return res + "";
    }
}
