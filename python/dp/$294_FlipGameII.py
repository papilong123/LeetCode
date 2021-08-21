class Solution:
    def __init__(self):
        self.memo = {}

    def canWin(self, currentState: str) -> bool:
        if currentState in self.memo:
            return self.memo[currentState]

        for i in range(len(currentState) - 1):
            if currentState[i] == "+" and currentState[i + 1] == "+":
                temp = currentState[:i] + "--" + currentState[i + 2:]
                # 看对手赢不赢的了，对手赢不了，说明当前我们这样翻(temp)是True的
                if not self.canWin(temp):
                    self.memo[currentState] = True
                    return True

        # 假如说发现对手都赢的了，那么当前s我们怎么翻都是输
        # 把当前s记录成False
        self.memo[currentState] = False
        return False
