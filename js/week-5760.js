/**
 * @param {string} s
 * @return {number}
 */
var minSwaps = function (s) {
    const n = s.length
    const target1 = new Array(n)
        .fill(0)
        .map((_, idx) => (idx % 2 === 0 ? 0 : 1))
        .join("")
    const target2 = new Array(n)
        .fill(0)
        .map((_, idx) => (idx % 2 === 1 ? 0 : 1))
        .join("")

    let ans1 = check(s, target1)
    let ans2 = check(s, target2)
    if (ans1 === -1) return ans2
    if (ans2 === -1) return ans1
    return Math.min(ans1, ans2)
}

const check = (s, target) => {
    const diff = [0, 0]
    for (let i = 0; i < s.length; i++) {
        if (s[i] !== target[i]) {
            diff[parseInt(s[i])]++
        }
    }

    return diff[0] === diff[1] ? diff[0] : -1
}
