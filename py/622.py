class MyCircularQueue:

    def __init__(self, k: int):
        self.queue = [0 for _ in range(k)]
        self.front = 0
        self.rear = 0
        self.k = k
        self.cnt = 0


    def enQueue(self, value: int) -> bool:
        if self.k == self.cnt:
            return False

        self.queue[self.rear] = value
        self.rear = (self.rear + 1) % self.k
        self.cnt += 1
        return True

    def deQueue(self) -> bool:
        if self.cnt == 0:
            return False

        self.front = (self.front + 1) % self.k
        self.cnt -= 1
        return True

    def Front(self) -> int:
        return self.queue[self.front] if self.cnt > 0 else -1

    def Rear(self) -> int:
        return self.queue[(self.rear - 1) % self.k] if self.cnt > 0 else -1

    def isEmpty(self) -> bool:
        return self.cnt == 0

    def isFull(self) -> bool:
        return self.cnt == self.k


# Your MyCircularQueue object will be instantiated and called as such:
# obj = MyCircularQueue(k)
# param_1 = obj.enQueue(value)
# param_2 = obj.deQueue()
# param_3 = obj.Front()
# param_4 = obj.Rear()
# param_5 = obj.isEmpty()
# param_6 = obj.isFull()