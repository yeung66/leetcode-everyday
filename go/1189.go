// https://leetcode-cn.com/problems/maximum-number-of-balloons/submissions/

func maxNumberOfBalloons(text string) int {
    as, bs, ns, ls,os := 0, 0, 0, 0, 0
    for _, i := range text {
        if i == 'a' {
            as += 1
        } else if (i == 'b') {
            bs += 1
        } else if (i == 'n') {
            ns += 1
        } else if (i == 'l') {
            ls += 1
        } else if (i == 'o') {
            os += 1
        }
    }

    return min(as, os, ns, ls / 2, os /2) 
}

func min(nums ...int) int {
    ans := 10000
    for _, i := range nums {
        if i < ans {
            ans = i
        }
    }

    return ans
}