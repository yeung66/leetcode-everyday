impl Solution {
    pub fn kth_grammar(n: i32, k: i32) -> i32 {
        if n == 0 {
            0
        } else {
            (k & 1) ^ 1 ^ Solution::kth_grammar(n-1, (k + 1) / 2)
        }
    }
}