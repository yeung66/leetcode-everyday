class Solution:
    def sortPeople(self, names: List[str], heights: List[int]) -> List[str]:
        return list(map(lambda x:names[x], sorted(list(range(len(names))), key=lambda x:heights[x], reverse=True)))