impl Solution {
    pub fn partition_disjoint(nums: Vec<i32>) -> i32 {
        let (mut left_pos, mut left_max, mut cur_max) = (0, nums[0], nums[0]);
        for i in 1..nums.len() {
            cur_max = std::cmp::max(cur_max, nums[i]);
            if nums[i] < left_max {
                left_max = cur_max;
                left_pos = i;
            }
        }

        left_pos as i32 + 1
    }
}