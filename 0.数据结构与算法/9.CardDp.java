package algorithm.tx;

public class CardDp {

	public static void main(String[] args) {
		
		int weigth[] = {1,2,3,4,5,9};	//购物车那个问题 只需要一个价值就行了，重量都都没有。
		
		int w = 8;
		int n = 6;
		int dp[][] = new int[n+1][w+1];		//n表示是物品，w表示重量,初始化全是0
		
		for(int i = 1; i<= n; i++){	//每次加的物品
			for(int cw = 1 ; cw <= w ; cw ++){		//分割的背包
				if(weigth[i - 1] <= cw){		//表示这个物品可以装进去
					dp[i][cw] = Math.max(
							weigth[i-1] + dp[i-1][cw-weigth[i-1]],
							dp[i-1][cw]
							);
				}else{
					dp[i][cw] = dp[i-1][cw];	//不能装
				}
			}
		}
		System.out.println(dp[n][w]);
		
	}
}
