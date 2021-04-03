// https://leetcode-cn.com/problems/volume-of-histogram-lcci/

/**
 * @param {number[]} height
 * @return {number}
 */
var trap1 = function (height) {

    const sum = (arr) => arr.reduce((a,b)=> a+b, 0)
  
    const divide = (start, end, maxIdx) => {
        if(end - start < 2) return 0
        const sub = height.slice(start, end)
        // console.log(sub, Math.max(...sub))

        const secondMaxIdx = sub.indexOf(Math.max(...sub)) + start
        const width = maxIdx > secondMaxIdx ? (maxIdx - secondMaxIdx - 1) : (secondMaxIdx - maxIdx - 1)
        const startIdx = maxIdx > secondMaxIdx ? secondMaxIdx + 1 : maxIdx + 1
        const endIdx = maxIdx > secondMaxIdx ? maxIdx: secondMaxIdx
        const vol = width * height[secondMaxIdx] - sum(height.slice(startIdx, endIdx))

        const ans = vol + (maxIdx > secondMaxIdx ? divide(start, secondMaxIdx, secondMaxIdx) : divide(secondMaxIdx + 1, end, secondMaxIdx))
        // console.log(start, end, maxIdx, secondMaxIdx, ans)
        return ans
    }

    const maxIdx = height.indexOf(Math.max(...height))
    return divide(0, maxIdx, maxIdx) + divide(maxIdx + 1, height.length, maxIdx)
};

const trap = (height) => {
    const n = height.length
    const leftMax = new Array(n).fill(0), rightMax = new Array(n).fill(0)
    leftMax[0] = height[0]
    rightMax[n-1] = height[n-1]

    for(let i=1;i<n;i++) leftMax[i] = Math.max(leftMax[i-1], height[i])
    for(let i=n-2;i>=0;i--) rightMax[i] = Math.max(rightMax[i+1], height[i])

    let ans = 0
    for(let i=0;i<n;i++) {
        ans += (Math.min(leftMax[i],rightMax[i])) - height[i]
    }
    return ans
}


const test = [0,1,0,2,1,0,1,3,2,1,2,1]

console.log(trap(test))