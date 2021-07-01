package main

func numWays(n int, relation [][]int, k int) int {
	res := make([]int, n)
	res[0] = 1

	for i:=0;i<k;i++ {
		temp := make([]int, n)
		for _, v := range relation {
			temp[v[1]] += res[v[0]]
		}
		res = temp
	}

	return res[n-1]
}
