impl Solution {
    pub fn is_unique(astr: String) -> bool {
        let mut mask = 0;
        for c in astr.bytes() {
            let bit = 1 << (c - b'a');
            if mask & bit != 0 {
                return false;
            }
            mask |= bit;
        }
        true
    }
}