class Solution {
    fun diagonalPrime(nums: Array<IntArray>): Int {
        val n = nums.size
        var ans = 0
        for ( i in 0 until n) {
            if (nums[i][i] > ans && isPrime(nums[i][i])) {
                ans = nums[i][i]
            }
            
            if (nums[i][n - i - 1] > ans && isPrime(nums[i][n - i - 1])) {
                ans = nums[i][n - i - 1]
            }
        }
        
        return ans
    }
    
    fun isPrime(num: Int): Boolean {
        if (num < 2) {
            return false
        }
        
        var i = 2
        while (i * i <= num) {
            if (num % i == 0) {
                return false
            }
            i++
        }
        
        return true
    }
}