/***
 * @author： Alascanfu
 * @date ： Created in 2022/2/28 19:17
 * @description： Leetcode 每日一题——1601. 最多可达成的换楼请求数目  测试类
 * @modified By： Alascanfu
 **/
public class Test1601 {
    @org.testng.annotations.Test
    public void test(){
        Solution1601 solution = new Solution1601();
        System.out.println(solution.maximumRequests(5, new int[][]{{0, 1}, {1, 0}, {0, 1}, {1, 2}, {2, 0}, {3, 4}}));
    }
}
