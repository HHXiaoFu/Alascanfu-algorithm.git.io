import java.util.ArrayList;
import java.util.List;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/7 12:14
 * @description： LeetCode每日一题 2100.适合打劫银行的日子
 * @modified By： Alascanfu
 **/
class Solution2100 {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[] leftDay = new int[n];
        int[] rightDay = new int[n];
        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) leftDay[i] = leftDay[i - 1] + 1;
            if (security[n - i - 1] <= security[n - i]) rightDay[n - i - 1] = rightDay[n - i] + 1;
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = time; i < n - time; i++) {
            if (leftDay[i] >= time && rightDay[i] >= time) res.add(i);
        }
        return res;
    }
}
