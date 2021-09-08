class Solution(object):
    def nextGreaterElement(self, nums1, nums2):
        d = {}
        stk = []
        for num in nums2:
            while stk and num > stk[-1]:  # 单减栈
                d[stk[-1]] = num  # 出栈时用字典记录栈顶元素与比起大的元素的一一对应关系
                stk.pop()
            stk.append(num)
        while stk:  # 没有比自己大的就设为其对应关系就设为-1
            d[stk.pop()] = -1
        ans = []
        for num in nums1:
            ans.append(d[num])
        return ans
