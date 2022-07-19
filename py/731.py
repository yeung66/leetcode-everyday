class MyCalendarTwo:

    def __init__(self):
        self.single_book = []
        self.double_book = []


    def book(self, start: int, end: int) -> bool:
        if any(s < end and start < e for s, e in self.double_book):
            return False

        for s, e in self.single_book:
            if s < end and start < e:
                self.double_book.append((max(s, start), min(end, e)))

        self.single_book.append((start, end))

        return True
                 


# Your MyCalendarTwo object will be instantiated and called as such:
# obj = MyCalendarTwo()
# param_1 = obj.book(start,end)