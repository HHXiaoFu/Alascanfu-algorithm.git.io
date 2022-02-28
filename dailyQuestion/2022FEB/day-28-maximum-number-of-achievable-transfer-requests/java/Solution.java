import java.util.Arrays;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/2/28 19:17
 * @description： 2022/02/28 Leetcode每日一题（Hard）——1601. 最多可达成的换楼请求数目
 * @modified By： Alascanfu
 **/
class Solution {
    public int maximumRequests(int n, int[][] requests) {
        // 获取提出更换请求的员工个数
        int m = requests.length;
        // max 代表的是员工的状态 -----> 员工请求的请求可以被接受 / 不接受 每个员工有两种状态 那么就有 2^m 次种状态结果
        int maxStatus = 1 << m, res = 0;
        // 记录是否成功接受请求的数组
        int[] netChangeArr = new int[n];
        
        // 枚举所有状态，二进制中 1 的个数为当前状态的请求个数
        for (int i = 0; i < maxStatus; i++) {
            int[] tmp = new int[n];
            int state = i;
            // 用于记录当前的员工请求下标
            int idx = 0;
            // 用于记录当前状态下的接受的请求个数
            int cnt = 0;
            // 用于获取当前状态中二进制数字中1的个数
            while (state > 0) {
                // 判断最后一位是否为1
                int isAccept = state & 1;
                // 如果为 1 则说明了当前状态被接受了 需要记录住房情况
                if (isAccept == 1) {
                    // 获取需要从哪里 搬到 哪里的位置信息
                    int from = requests[idx][0];
                    int to = requests[idx][1];
                    // 记录住房净变化
                    tmp[from]--;
                    tmp[to]++;
                    cnt++;
                }
                // 获取前一个员工的状态请求情况
                state >>= 1;
                idx++;
            }
            // 根据我们上面完成得到记录住房变化 需要满足每栋楼员工净变化为 0
            // 滚动获取最大值
            if (Arrays.equals(tmp, netChangeArr)) {
                res = Math.max(res,cnt);
            }
        }
        return res;
    }
}