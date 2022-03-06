/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/6 14:10
 * @description： IntegerDichotomyTemplate2
 * @modified By： Alascanfu
 **/
public class IntegerDichotomyTemplate2 {
    // 检查x是否满足某种性质
    public boolean check(int x){
        return true;
    }
    // 区间[l, r]被划分成[l, mid - 1]和[mid, r]时使用：
    public int bSearch_2(int l,int r){
        while (l < r){
            int mid = l + r + 1 >> 1;
            if (check(mid)) l=mid;
            else r = mid-1;
        }
        return l;
    }
}
