class Solution:
    def possibleBipartition(self, n: int, dislikes: List[List[int]]) -> bool:
        relations = defaultdict(set)
        for a, b in dislikes:
            relations[a].add(b)
            relations[b].add(a)

        colors = [0 for _ in range(n+1)]
        colors[0] = True

        def dfs(i, color):
            colors[i] = color
            return all(colors[j] != color and (colors[j] or dfs(j, -color))  for j in relations[i])

        return all(c or dfs(i, 1) for i, c in enumerate(colors))