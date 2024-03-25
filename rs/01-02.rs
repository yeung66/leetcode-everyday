impl Solution {
    pub fn check_permutation(s1: String, s2: String) -> bool {
        let mut cnt = [0; 26];
        for c in s1.bytes() {
            cnt[(c - b'a') as usize] += 1;
        }
        for c in s2.bytes() {
            cnt[(c - b'a') as usize] -= 1;
        }
        
        cnt.iter().all(|&x| x == 0)
    }
}