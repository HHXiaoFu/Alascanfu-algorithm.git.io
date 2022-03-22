/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/22 17:04
 * @description： LeetCode每日一题.2038 如果相邻两个颜色均相同则删除当前颜色
 * @modified By： Alascanfu
 **/
class Solution2038{
    public boolean winnerOfGame(String colors) {
        int n = colors.length() ;
        boolean isAliceWin = false;
        if ( n < 3 )return isAliceWin;
        int aliceWinCnt = getDeletCnt(colors,true);
        int bobWinCnt = getDeletCnt(colors,false);
        isAliceWin = aliceWinCnt > bobWinCnt?true : false;
        return isAliceWin;
        
    }
    int getDeletCnt(String colors,boolean isAlice){
        int cnt = 0 ;
        char deleteChar = isAlice ? 'A' : 'B';
        for (int i = 1 ; i< colors.length()-1;i++){
            if (deleteChar == colors.charAt(i) && deleteChar == colors.charAt(i-1) && deleteChar == colors.charAt(i+1))cnt++;
        }
        
        return cnt ;
    }
}
