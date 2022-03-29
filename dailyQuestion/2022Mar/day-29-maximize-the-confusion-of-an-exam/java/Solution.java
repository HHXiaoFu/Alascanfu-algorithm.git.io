/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/29 16:14
 * @description： Leetcode每日一题2024.考试的最大困扰度 2022/03/29
 * @modified By： Alascanfu
 **/
class Solution2024 {
    /**
     * 功能描述
     * 滑窗理解
     *
     * @date 2022/3/29
     * @author Alascanfu
     */
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int i = 0;
        int j = 0;
        int cntT = 0;
        int cntF = 0;
        int n = answerKey.length();
        char[] keys = answerKey.toCharArray();
        
        while (j < n) {
            if (keys[j] == 'T') {
                cntT++;
            } else {
                cntF++;
            }
            
            int curNeedModifyKeysCnt = Math.min(cntF, cntT);
            if (curNeedModifyKeysCnt > k) {
                if (keys[i] == 'T') cntT--;
                else if (keys[i] == 'F') cntF--;
                i++;
            }
            j++;
        }
        return j - i;
    }
    
    /**
     * 功能描述
     * 经典滑窗
     *
     * @date 2022/3/29
     * @author Alascanfu
     */
    
    public int maxConsecutiveAnswers1(String answerKey, int k) {
        return Math.max(getCnt(answerKey, k, 'T'), getCnt(answerKey, k, 'F'));
    }
    
    int getCnt(String s, int k, char c) {
        int n = s.length();
        int res = 0;
        for (int i = 0, j = 0, cnt = 0; i < n; i++) {
            if (s.charAt(i) == c) cnt++;
            while (cnt > k) {
                if (s.charAt(j) == c) cnt--;
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
    
}
