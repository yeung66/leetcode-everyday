impl Solution {
    pub fn divisor_game(n: i32) -> bool {
        if n < 3 {
            return n == 2;
        }

        let mut dp: Vec<bool> = (0..=n).into_iter().map(|_| false).collect();
        dp[2] = true;

        for i in 3..=n {
            for j in 1..i {
                if i % j == 0 && !dp[(i - j) as usize] {                    
                    dp[i as usize] = true;
                    break;
                }
            }
        }

        dp[n as usize]
    }

}