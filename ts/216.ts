function combinationSum3(k: number, n: number): number[][] {
    const ans: number[][] = []
    const dfs = (target, idx, path: number[]) => {
        if (target === 0) {
            if (path.length === k) {
                ans.push([...path])
            }
            return
        }

        if (idx > 9 || path.length >= k) return

        dfs(target, idx + 1, path)
        if (target - idx >= 0) {
            path.push(idx)
            dfs(target - idx, idx + 1, path)
            path.pop()
        }
    }

    dfs(n, 1, [])

    return ans
};