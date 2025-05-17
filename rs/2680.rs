impl Solution {
    pub fn maximum_or(nums: Vec<i32>, k: i32) -> i64 {
        let n = nums.len();
        let mut suf = vec![0 as i64; n + 1];
        for i in (0..n).rev() {
            suf[i] = suf[i + 1] | (nums[i] as i64);
        }
        
        let mut ans = 0;
        let mut pre = 0;
        for i in 0..n {
            ans = ans.max(pre | suf[i + 1] | ((nums[i] as i64) << k));
            pre |= nums[i] as i64;
        }
        
        ans
    }
}