/**
 * @param {number} n
 * @return {number}
 */
var countNumbersWithUniqueDigits = function(n) {
    let dp = new Array(n + 1).fill(0)
    dp[0] = 0
    dp[1] = 10
    for (let i = 2; i <= n; i++) {
        dp[i] = dp[i-1] + (dp[i-1] - dp[i-2])*(10-(i-1));
    }

    return dp[n]
}