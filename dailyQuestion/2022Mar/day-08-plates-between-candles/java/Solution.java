/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/8 17:04
 * @description： Leetcode每日一题2055.蜡烛之间的盘子 2022/03/08
 * @modified By： Alascanfu
 **/
class Solution2055 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int m = s.length();
        int n = queries.length;
        // 分别用于记录当前位置下其左侧最近的蜡烛下标位置，以及当前位置下右侧最近的蜡烛下标位置
        int[] leftNearestCan = new int [m+1],rightNearestCan = new int [m+1],prefix = new int[m+1];
        // 初始化边界 如果找不到最近的蜡烛 则直接返回边界位置
        leftNearestCan[0] = -1;
        rightNearestCan[m] = m;
        // 预处理
        for (int i = 1;i<=m;i++){
            // 用来求取当前位置的盘子个数
            prefix[i] = prefix[i-1] + (s.charAt(i-1) == '*' ? 1 : 0);
            // 这里是获取当前位置下 左侧最近的蜡烛下标
            leftNearestCan[i] = (s.charAt(i-1) == '|' ? i-1 : leftNearestCan[i-1]);
            // 这里是获取当前位置下 右侧最近的蜡烛下标
            rightNearestCan[m-i] = (s.charAt(m-i) == '|'? m-i : rightNearestCan[m-i+1]);
        }
        
        int[] res = new int [n];
        
        for (int i = 0 ; i< n;i++){
            // 记录当前查询位置的右侧最近的Idx，以及当前查询位置的左侧最近|的 Idx
            int lIdx = rightNearestCan[queries[i][0]],  rIdx = leftNearestCan[queries[i][1] + 1];
            // 为了防止当前查询左右位置相同 也就是子字符串为1的情况下 跳过当前查询
            if(lIdx+1 >= rIdx)continue;
            // 前缀和计算当前位置的满足条件的盘子个数
            res[i] = prefix[rIdx+1] - prefix[lIdx];
        }
        return res;
    }
}
