from typing import List


class Solution:
    # 只考虑手中的钱最多，买相当于减，卖相当于加，这一次是买还是卖只与上一次是买还是卖有关
    # 整体属于dp思想，对于第i价格，利润与之前价格都有关系，所以需要buy = max(buy, ？)，sell = max(sell, ？)
    # 即dp滚动数组思想，这意味着，我们每天（第i天为结尾）都在买卖（dp就是循环推导）
    def maxProfit(self, prices: List[int]) -> int:
        # def maxProfit(self, k: int, prices: List[int]) -> int:
        # def maxProfit(self, prices: List[int], fee: int) -> int:

        # 买卖一次
        buy, sell = -float('inf'), 0  # buy一定初始化为无穷小，因为第一次买看成手中钱减少（是个负数），sell初始化小于等于0
        for p in prices:
            buy = max(buy, 0 - p)  # 由于只能买一次，买之前手里只有0元，买之后手里有max(buy, 0-p)
            sell = max(sell, buy + p)  # 卖之前一定是买buy，卖完手里有max(sell, buy+p)
        return sell

        # 不限制买卖次数
        # buy, sell = -float('inf'), 0
        # for p in prices:
        #     buy = max(buy, sell-p) # 由于不限制交易次数，买之前可能是卖过手里的钱sell，买之后max(buy, sell-p)
        #     sell = max(sell, buy+p) # 卖之前一定是买buy，卖完手里有max(sell, buy+p)
        # return sell

        # 买卖两次
        # buy1, sell1, buy2, sell2 = -float('inf'), 0, -float('inf'), 0
        # for p in prices:
        #     buy1 = max(buy1, 0-p)
        #     sell1 = max(sell1, buy1+p)
        #     buy2 = max(buy2, sell1-p)
        #     sell2 = max(sell2, buy2+p) # 整体而言，这次操作只与上一次有关
        # return sell2

        # 买卖k次
        # buy = [-float('inf')] * (k+1)
        # sell = [0] * (k+1) # 初始化为k+1，是因为第一次买，是0-p，这里我们sell[0]=0，就可以了
        # for p in prices:
        #     for k in range(1, k+1):
        #         buy[k] = max(buy[k], sell[k-1]-p) # 第一次sell[i-1]=sell[0]=0
        #         sell[k] = max(sell[k], buy[k]+p)
        # return sell[-1]

        # 不限制买卖次数，冻结期为1天
        # buy, sell_pre, sell_now = -float('inf'), 0, 0
        # # 冻结期为1天，意味着，我们买的上一个状态不能是上一次卖的，而是上上次卖的
        # # 至此，要理解，这是dp滚动数组思想，这意味着，我们每天都在买卖
        # for p in prices:
        #     buy = max(buy, sell_pre-p) # 这次买的是接着上上次卖的，可以理解为buy[i]与sell[j-1]有关，而不是sell[j]
        #     sell_pre = sell_now # 因为后面要更新sell_now，这里要先保存，buy[i-1]的记录
        #     sell_now = max(sell_now, buy+p)
        # return sell_now

        # 不限制买卖次数，但是有手续费
        # buy, sell = -float('inf'), 0
        # for p in prices:
        #     buy = max(buy, sell-fee-p) # 多减去手续费即可
        #     sell = max(sell, buy+p)
        # return sell
