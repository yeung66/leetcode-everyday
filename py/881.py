class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        people.sort(reverse=True)
        left, right = 0, len(people) - 1
        boats = 0
        while left < right:
            if people[left] + people[right] <= limit:
                right -= 1
            boats += 1
            left += 1

        return boats + (1 if left == right else 0)


