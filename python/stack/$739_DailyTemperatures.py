class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        ans, st = [0] * len(temperatures), []
        for i in range(len(temperatures)):
            while st and temperatures[i] > temperatures[st[-1]]:
                ans[st[-1]] = i - st[-1]
                st.pop()
            st.append(i)
        return ans
