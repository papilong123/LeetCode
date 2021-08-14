class PriorityQueue:
    def __init__(self, cmp):
        self.max_size = 10000
        self.cmp = cmp
        self.array = [None for _ in range(self.max_size)]
        self.length = 0

    def offer(self, obj):
        index = self.length
        self.array[index] = obj
        self.length += 1
        while index > 0:
            parent = (index - 1) // 2
            if self.cmp(self.array[parent], self.array[index]) > 0:
                self.array[parent], self.array[index] = self.array[index], self.array[parent]
                index = parent
            else:
                break

    def pop(self):
        obj = self.array[0]
        self.array[0] = self.array[self.length - 1]
        self.length -= 1
        self.adjust_heap(0)
        return obj

    def peek(self):
        return self.array[0]

    def is_empty(self):
        return self.length == 0

    def adjust_heap(self, i):
        while i < self.length:
            left, right, min_index = 2 * i + 1, 2 * i + 2, i
            if left < self.length and self.cmp(self.array[min_index], self.array[left]) > 0:
                min_index = left
            if right < self.length and self.cmp(self.array[min_index], self.array[right]) > 0:
                min_index = right
            if min_index != i:
                self.array[min_index], self.array[i] = self.array[i], self.array[min_index]
                i = min_index
            else:
                break
