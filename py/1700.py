class Solution:
    def countStudents(self, students: List[int], sandwiches: List[int]) -> int:
        for i in sandwiches:
            left = len(students)
            while students[0] != i and left > 0:
                students.append(students.pop(0))
                left -= 1

            if students[0] != i:
                return len(students)
            else:
                students.pop(0)

        return 0
