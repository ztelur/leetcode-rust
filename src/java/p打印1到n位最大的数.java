package java;

/**
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/solution/mian-shi-ti-17-da-yin-cong-1-dao-zui-da-de-n-wei-2/
 */
class Solution {

    int[] res;
    //s tart表示该数字当前左边界，这个左边界意思是指当前数字最高位对应的char数组下标。如n=2时，1~9左边界为1，10~99左边界为0
    //nine表示当前数字中出现了多少个9，如果出现1个9，左边界就要向左移1位。例如第1次出现“9”是在9这个数字出现的时候，此时nine++变为1，
    //进入下次递归n为2，nine为1，start为1，此时start就要-1，以便统计二位数字
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public int[] printNumbers(int n) {
        this.n = n;
        // 因为要打印从 1 到 n 位最大的数，所以 Math.pow(10,n) - 1 就正好
        res = new int[(int)Math.pow(10, n) - 1];
        //num数组用来表示字符串，比如n等于2，则num数组为['0''0']、['0''1']、['0''2']...后边是将它转为字符串并按照左边界的位置进行截取的
        num = new char[n];
        // 从 n-1 位开始
        start = n - 1;
        dfs(0);
        return res;
    }
    // x 表示当前规划到第 x 位了
    void dfs(int x) {
        // 如果 x = n，表示已经规划完了
        // 结束条件：当前x的下标越过char数组的最后一位下标n-1，此时记录结果
        if(x == n) {
            // //从start开始截取字符串，如"01"截取后就是"1"
            String s = String.valueOf(num).substring(start);
            // //防止将"0"、"00"、"000"加进来
            if(!s.equals("0")) res[count++] = Integer.parseInt(s);
            // //n减去start等于nine，表示要进位了，进位就是将左边界start左移一位，即-1
            if(n - start == nine) start--;
            return;
        }
        // 给char数组第x位添加数字，添加完后进入下一位
        for(char i : loop) {
            if(i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        // //回溯
        nine--;
    }
}


public class Solution2 {
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    StringBuilder sb = new StringBuilder();
    public String printNumber(int len){
        num = new char[len];
        for(int i = 1;i<=len;i++){
            dfs(0,i);
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }
    public void dfs(int index,int len){
        if(index == len){
            sb.append(new String(num)+",");
            return;
        }
        int start = 0;
        //若从0作为起点：if(index == 0 && len>1)
        //若从1作为起点
        if(index == 0){
            start = 1;
        }else{
            start = 0;
        }
        for(int i=start;i<10;i++){
            num[index] = loop[i];
            dfs(index+1,len);
        }
    }
}
