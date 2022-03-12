import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/12 10:52
 * @description： Leetcode 每日一题 590.N叉树的后序遍历 测试类
 * @modified By： Alascanfu
 **/
public class Test590 {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        
        String[] params = br.readLine().split(",");
        
    }
}

class Node {
    public int val;
    public List<Node> children;
    
    public Node() {}
    
    public Node(int val) {
        this.val = val;
    }
    
    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
