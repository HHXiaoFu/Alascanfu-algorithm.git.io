import java.util.Stack;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/26 13:30
 * @description： Leetcode每日一题 682.棒球比赛 2022/03/26
 * @modified By： Alascanfu
 **/
class Solution682 {
    public int calPoints(String[] ops) {
        int score = 0 ;
        Stack<Integer> stack = new Stack<>();
        for (String operate : ops){
            if (operate.equals("+")){
                int peekScore = stack.peek();
                int curScore = stack.peek();
                for (int i = 0;i< 2;i++){
                    score += stack.peek();
                    if (i == 0)stack.pop();
                    else curScore += stack.peek();
                }
                stack.push(peekScore);
                stack.push(curScore);
            }else if (operate.equals("D")){
                score += stack.peek()*2;
                stack.push(stack.peek()*2);
                
            }else if (operate.equals("C")){
                int invalidScore = stack.pop();
                score -= invalidScore;
            }else {
                stack.push(Integer.parseInt(operate));
                score += stack.peek();
            }
        }
        return score;
    }
}
