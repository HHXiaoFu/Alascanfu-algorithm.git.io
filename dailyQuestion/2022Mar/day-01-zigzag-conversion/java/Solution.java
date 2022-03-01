import java.util.ArrayList;
import java.util.List;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/1 9:41
 * @description： LeetCode每日一题—— 2022/03/01 Z字形变换
 * @modified By： Alascanfu
 **/
class Solution6 {
        public String convert(String s, int numRows) {
            // 这个当字符行只有一行时 直接进行返回即可
            if (numRows == 1) {
                return s;
            }
            // 我们利用列表来存储每行的字符数据
            List<StringBuilder> list = new ArrayList<>();
            // 初始化字符数据
            for (int i = 0 ;i< numRows;i++){
                list.add(new StringBuilder());
            }
            // 设置方向 因为我们当刚进入的时候 字符下标idx = 0 此时不需要转向所以为了防止转向 设置为 -1
            int isDown = -1;
            
            int n = s.length();
            // 模拟
            for (int i = 0 ,idx = 0 ;i < n;i++){
                // 如果字符行下标到达0或者numRows-1则需要进行转向
                if (idx == 0 || idx == numRows - 1){
                    isDown = -isDown;
                }
                // 往当前字符行中添加字符数据
                list.get(idx).append(s.charAt(i));
                // 位移
                idx += isDown;
            }
            // 用于记录结果的
            StringBuilder res = new StringBuilder();
            // 将每个字符行数据集逐行合并拼接就是结果数据
            for (int i = 0 ;i<numRows;i++){
                res.append(list.get(i).toString());
            }
            return res.toString();
        }
    
}
