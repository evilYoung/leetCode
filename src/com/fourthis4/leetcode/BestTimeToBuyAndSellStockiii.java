package com.fourthis4.leetcode;

/**
 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。

 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BestTimeToBuyAndSellStockiii {
    public int maxProfit(int[] prices) {
        int b1 = prices[0], b2 = -prices[0];
        int s1 = 0, s2 = 0;

        for (int i = 0; i < prices.length; i++) {
            b1 = Math.min(b1, prices[i]);
            s1 = Math.max(s1, prices[i] - b1);
            b2 = Math.max(b2, s1 - prices[i]);
            s2 = Math.max(s2, b2 + prices[i]);
        }

        return s2;
    }
}
