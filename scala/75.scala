object Solution {
    def sortColors(nums: Array[Int]): Unit = {
        var red = 0
        var white = 0
        var blue = nums.length - 1

        while (white <= blue) {
            nums(white) match {
                case 0 =>
                    swap(nums, red, white)
                    red += 1
                    white += 1
                case 1 =>
                    white += 1
                case 2 =>
                    swap(nums, white, blue)
                    blue -= 1
            }
        }
    }
    
    def swap(nums: Array[Int], i: Int, j: Int): Unit = {
        val temp = nums(i)
        nums(i) = nums(j)
        nums(j) = temp
    }
}