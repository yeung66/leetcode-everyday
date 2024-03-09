function majorityElement(nums: number[]): number {
  let start = nums[0], cnt = 1;
  for (let i = 1; i < nums.length; i++) {
    if (nums[i] === start) {
      cnt++;
    } else {
      cnt--;
      if (cnt === 0) {
        start = nums[i];
        cnt = 1;
      }
    }
  }

  return start
};