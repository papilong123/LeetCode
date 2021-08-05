class Solution(object):
    def nextGreaterElement(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        hashmap = dict()
        st = []
        for num in nums2:
            while st and num > st[-1]:
                hashmap[st[-1]] = num
                st.pop()
            st.append(num)
        while st:
            hashmap[st.pop()] = -1
        ans = []
        for num in nums1:
            ans.append(hashmap[num])
        return ans
