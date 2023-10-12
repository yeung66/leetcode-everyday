function findTheArrayConcVal(nums: number[]): number {
    // 递归版
    // const rec = (nums: number[], acc: number): number => {
    //     if (nums.length === 0) return acc;
    //     if (nums.length === 1) return nums[0] + acc;

    //     return rec(nums.slice(1, nums.length-1), acc + parseInt(nums[0].toString().concat(nums[nums.length-1].toString())));
    // }
    
    // return rec(nums, 0);

    // 迭代版
    let acc = 0, i = 0, j = nums.length - 1;
    while (i < j) {
        acc += parseInt(nums[i].toString().concat(nums[j].toString()));
        i++;
        j--;
    }

    if (i === j) acc += nums[i];
    return acc;
};