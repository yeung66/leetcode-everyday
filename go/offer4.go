// https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof

func findNumberIn2DArray(matrix [][]int, target int) bool {
    m := len(matrix)
    if m == 0 {
        return false
    }
    n := len(matrix[0])
    i, j := 0, n-1
    for i < m && j >= 0 {
        if matrix[i][j] == target {
            return true
        } else if matrix[i][j] < target {
            i += 1
        } else {
            j -= 1
        }
    }

    return false
}