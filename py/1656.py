class OrderedStream:

    def __init__(self, n: int):
        self.data = [None] * (n+1)
        self.ptr = 1
        self.n = n


    def insert(self, idKey: int, value: str) -> List[str]:
        ans = []
        self.data[idKey] = value
        if idKey == self.ptr:            
            while self.ptr <= self.n and self.data[self.ptr]:
                ans.append(self.data[self.ptr])
                self.ptr += 1

        return ans



# Your OrderedStream object will be instantiated and called as such:
# obj = OrderedStream(n)
# param_1 = obj.insert(idKey,value)