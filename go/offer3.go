// https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/submissions/

// func findRepeatNumber(nums []int) int {
//     cnt := map[int]struct{} {}
//     for _, i := range nums {
//         if _, ok := cnt[i]; ok {
//             return i
//         } else {
//             cnt[i] = struct{} {}
//         }
//     }

//     return 0
// }


func findRepeatNumber(nums []int) int {
    idx := 0
    for idx < len(nums) {
        if nums[idx] == idx {
            idx++
            continue
        }

        if nums[idx] == nums[nums[idx]] {
            break
        } else {
            nums[idx], nums[nums[idx]] = nums[nums[idx]], nums[idx]
        }
    }

    return nums[idx]
}