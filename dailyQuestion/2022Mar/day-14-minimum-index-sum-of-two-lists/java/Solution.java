import java.util.HashMap;
import java.util.Map;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/14 16:32
 * @description： Leetcode 每日一题 599.两个列表的最小索引和 2022/03/14
 * @modified By： Alascanfu
 **/
class Solution599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        
        for (int i = 0 ; i< list1.length; i++ )map1.put(list1[i],i);
        for (int i = 0 ; i< list2.length; i++ )map2.put(list2[i],i);
        
        int minIdxSum = map1.size() + map2.size() - 2;
        
        for (String s :map1.keySet()){
            if(map2.containsKey(s)){
                int idxSum = map1.get(s) + map2.get(s);
                minIdxSum = Math.min(minIdxSum,idxSum);
            }
        }
        
        StringBuilder res = new StringBuilder();
        for (String s : map1.keySet()){
            if (map2.containsKey(s) && map1.get(s) + map2.get(s) == minIdxSum)res.append(s+",");
        }
        return res.toString().split(",");
    }
}
