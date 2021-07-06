/*
 * @lc app=leetcode.cn id=451 lang=golang
 *
 * [451] 根据字符出现频率排序
 *
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/description/
 *
 * algorithms
 * Medium (67.60%)
 * Likes:    303
 * Dislikes: 0
 * Total Accepted:    64.9K
 * Total Submissions: 92.8K
 * Testcase Example:  '"tree"'
 *
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 *
 *
 * 输入:
 * "tree"
 *
 * 输出:
 * "eert"
 *
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 *
 *
 * 示例 2:
 *
 *
 * 输入:
 * "cccaaa"
 *
 * 输出:
 * "cccaaa"
 *
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 *
 *
 * 示例 3:
 *
 *
 * 输入:
 * "Aabb"
 *
 * 输出:
 * "bbAa"
 *
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 *
 *
 */
package main

import (
	"fmt"
	"sort"
)

// @lc code=start
type charCount struct {
	char byte
	count int
}

type Counts []charCount

func (c Counts) Len() int {
	return len(c)
}

func (c Counts) Swap(i, j int) {
	c[i], c[j] = c[j], c[i]
}

func (c Counts) Less(i, j int) bool {
	return c[i].count>c[j].count
}

func frequencySort(s string) string {
	freqCount := map[byte]int{}
	for i:=0;i<len(s);i++ {
		char := s[i]
		freqCount[char]++
	}

	counts := make(Counts, len(freqCount))
	i:=0
	for k, v := range freqCount {
		counts[i] = charCount{k,v}
		i++
	}

	sort.Sort(counts)

	ans := ""
	for i=0;i<len(counts);i++ {
		char := fmt.Sprintf("%c", counts[i].char)
		for j:=0;j<counts[i].count;j++ {
			ans += char
		}
	}
	return ans
 

}
// @lc code=end

