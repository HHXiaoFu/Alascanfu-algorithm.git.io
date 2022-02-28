/***
 * @author： Alascanfu
 * @date ： Created in 2022/2/28 19:17
 * @description： Leetcode 每日一题——1601. 最多可达成的换楼请求数目  测试类
 * @modified By： Alascanfu
 **/
public class Test {
    @org.testng.annotations.Test
    public void test1(){
        Solution solution = new Solution();
        System.out.println(solution.maximumRequests(5, new int[][]{{0, 1}, {1, 0}, {0, 1}, {1, 2}, {2, 0}, {3, 4}}));
    }
}
