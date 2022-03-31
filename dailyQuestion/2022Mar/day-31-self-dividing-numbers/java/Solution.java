import java.util.ArrayList;
import java.util.List;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/31 18:08
 * @description： Leetcode 每日一题728.自除数
 * @modified By： Alascanfu
 **/
class Solution728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left ; i<= right;i++){
            int curNum = i;
            if (check(curNum))res.add(curNum);
        }
        return res;
    }
    boolean check(int num){
        int tmp = num;
        while (tmp > 1 ){
            int i = tmp % 10;
            if (i == 0 || num % i != 0)return false;
            tmp/= 10;
        }
        return true;
    }
}
