import java.util.*;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/5/11 10:19
 * @description： Binary Search Tree Encodes And Decodes
 * @modified By： Alascanfu
 **/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        doSerialize(root , str);
        return str.toString();
    }
    
    public void doSerialize(TreeNode root,StringBuilder str){
        if (root == null){
            str.append("#").append(",");
            return ;
        }
        str.append(root.val).append(",");
        doSerialize(root.left,str);
        doSerialize(root.right,str);
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return doDeserialize(new LinkedList<String>(Arrays.asList(data.split(","))));
    }
    
    TreeNode doDeserialize(List<String> node){
        if (node.get(0).equals("#")){
            node.remove(0);
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(node.get(0)));
        node.remove(0);
        root.left = doDeserialize(node);
        root.right = doDeserialize(node);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;