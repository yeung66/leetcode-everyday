function singleNumber(nums: number[]): number[] {
    let xor = nums.reduce((a, b) => a ^ b);
    let mask = xor & (-xor);
    let ans = [0, 0];
    for (let num of nums) {
        if ((num & mask) === 0) {
            ans[0] ^= num;
        } else {
            ans[1] ^= num;
        }
    }

    return ans;
};