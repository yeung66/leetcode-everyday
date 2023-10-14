function singleNumber(nums: number[]): number {
    return nums.reduce((i, acc) => acc ^ i)
}
