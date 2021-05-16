/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 */
var FindSumPairs = function (nums1, nums2) {
    this.nums1 = nums1
    this.nums1Count = new Map()
    nums1.forEach((x) => {
        let prev = this.nums1Count.get(x)
        this.nums1Count.set(x, prev + 1 || 1)
    })
    this.nums2 = nums2
}

/**
 * @param {number} index
 * @param {number} val
 * @return {void}
 */
FindSumPairs.prototype.add = function (index, val) {
    this.nums2[index] += val
}

/**
 * @param {number} tot
 * @return {number}
 */
FindSumPairs.prototype.count = function (tot) {
    let ans = 0
    for (let i of this.nums2) {
        if (i >= tot) continue
        let target = tot - i
        if (this.nums1Count.has(target)) ans += this.nums1Count.get(target)
    }
    return ans
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * var obj = new FindSumPairs(nums1, nums2)
 * obj.add(index,val)
 * var param_2 = obj.count(tot)
 */
