class MyCalendar:

    def __init__(self):
        self.events = []
        

    def book(self, startTime: int, endTime: int) -> bool:
        target = len(self.events)
        for idx, (l, r) in enumerate(self.events):
            if l <= startTime < r or l < endTime <= r or startTime <= l < r <= endTime:
                return False

            if endTime <= l:
                target = idx
                break

        self.events.insert(target, (startTime, endTime))
        return True
        


# Your MyCalendar object will be instantiated and called as such:
# obj = MyCalendar()
# param_1 = obj.book(startTime,endTime)