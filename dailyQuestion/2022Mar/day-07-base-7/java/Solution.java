import java.util.Stack;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/7 12:40
 * @description： LeetCode 每日一题 504 7进制数 2022/03/07
 * @modified By： Alascanfu
 **/
class Solution504 {
    // api调用
    public String convertToBase7(int num) {
        return Integer.toString(num, 7);
    }
    
    // 短除法模拟进制计算
    public String convertToBase7_1(int num) {
        if (num == 0) return "0";
        Stack<Integer> stack = new Stack<>();
        boolean isNegativeNum = false;
        isNegativeNum = num < 0 ? true : false;
        num = Math.abs(num);
        while (num > 0) {
            stack.push(num % 7);
            num /= 7;
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) res.append(stack.pop());
        return isNegativeNum ? "-" + res.toString() : res.toString();
    }
    
    // 栈的合理应用
    public String convertToBase7_2(int num) {
        if (num == 0) return "0";
        Stack<Integer> stack = new Stack<>();
        boolean isNegativeNum = false;
        isNegativeNum = num < 0 ? true : false;
        num = Math.abs(num);
        while (num > 0) {
            stack.push(num % 7);
            num /= 7;
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) res.append(stack.pop());
        return isNegativeNum ? "-" + res.toString() : res.toString();
    }
}
