爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：

爱丽丝以 0 分开始，并在她的得分少于 K 分时抽取数字。 抽取时，她从 [1, W] 的范围中随机获得一个整数作为分数进行累计，其中 W 是整数。 每次抽取都是独立的，其结果具有相同的概率。

当爱丽丝获得不少于 K 分时，她就停止抽取数字。 爱丽丝的分数不超过 N 的概率是多少？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/new-21-game
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

class Solution {
    public double new21Game(int N, int K, int W) {
        if(N-K+1>=W) return 1.0;
        double[] dp=new double[K+W];
        for(int i=K;i<=N;i++){
            dp[i]=1.0;
        }
        double sum=N-K+1;
        for(int i=K-1;i>=0;i--){
            dp[i]=sum/W;
            sum+=dp[i]-dp[i+W];
        }
        return dp[0];
    }
}