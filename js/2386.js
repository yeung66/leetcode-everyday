var kSum = function(nums, k) {
    const n = nums.length;
    let total = 0;
    for (let i = 0; i < nums.length; i++) {
        const x = nums[i];
        if (x >= 0) {
            total += x;
        } else {
            nums[i] = -x;
        }
    }
    
    nums.sort((a, b) => a - b);
    let ret = 0;
    const pq = new MinPriorityQueue();
    pq.enqueue([nums[0], 0], nums[0]);
    for (let j = 2; j <= k; j++) {
        const [t, i] = pq.front().element;
        pq.dequeue();
        ret = t;
        if (i == n - 1) {
            continue;
        }
        pq.enqueue([t + nums[i + 1], i + 1], t + nums[i + 1]);
        pq.enqueue([t - nums[i] + nums[i + 1], i + 1], t - nums[i] + nums[i + 1]);
    }
    return total - ret;
};