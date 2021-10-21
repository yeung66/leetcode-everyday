class Solution {
    fun minMoves(nums: IntArray): Int {
        var min = nums.toList().minOrNull()
    
        var ans = 0
        for(i in nums) {
            ans += i - min!!
            
        }
        return ans
    }
}