function maxSatisfaction(satisfaction: number[]): number {
    satisfaction.sort((a, b) => a - b)
    let dp: number[][] = new Array(satisfaction.length + 1)
        .fill(0)
        .map( () => new Array(satisfaction.length + 1).fill(0) )

    let max = 0
    for (let i = 1; i <= satisfaction.length; i++) {
        for (let j = 1; j < i; j++) {
            dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1] + satisfaction[i-1] * j)
            max = Math.max(max, dp[i][j])
        }

        dp[i][i] = dp[i-1][i-1] + satisfaction[i-1] * i
        max = Math.max(max, dp[i][i])
    }

    // console.log(satisfaction)
    // console.log(dp)

    return max
};

// maxSatisfaction([-1,-8,0,5,-7])