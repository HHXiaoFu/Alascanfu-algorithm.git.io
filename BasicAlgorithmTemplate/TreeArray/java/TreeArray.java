/***
 * @author： Alascanfu
 * @date ： Created in 2022/4/4 16:24
 * @description： 树形数组模板
 * @modified By： Alascanfu
 **/
public class TreeArray {
    int n ;
    int [] tree;
    int [] nums;
    int lowbit(int x){
        return x & -x;
    }
    
    void add(int x , int u){
        for (int i = x ; i<= n;i+=lowbit(i))tree[i]+=u;
    }
    
    int query(int x){
        int res = 0;
        for (int i = x; i > 0;i-=lowbit(i))res += tree[i];
        return res;
    }
    
    public void init(int[] nums){
        this.n = nums.length;
        this.nums = nums;
        tree = new int[n+1];
        for (int i = 0 ; i< n;i++)add(i+1,nums[i]);
    }
    
    /**
     * 功能描述
     * 单点修改
     * @date 2022/4/4
     * @author Alascanfu
     */
    void updateOneNum(int index ,int val ){
        add(index+1,val - nums[index]);
        nums[index] = val;
    }
    
    /**
     *功能描述
     * 单点查询
     * @date 2022/4/4
     *  @author Alascanfu
     */
    int queryOneNum(int index){
        return query(index + 1) - query(index);
    }
    
    /**
     * 功能描述
     * 区间查询
     * @date 2022/4/4
     * @author Alascanfu
     */
    int sumRanges(int left ,int right ){
        return query(right + 1) - query(left);
    }
    
    /**
     *功能描述
     * 区间修改
     * @date 2022/4/4
     *  @author Alascanfu
     */
    void updateIntervalChanges(int left ,int right ,int val){
        add(left+1,val);
        add(right+1 ,-val);
    }
    
    
}

