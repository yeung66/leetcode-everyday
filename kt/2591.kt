class Solution {
    fun distMoney(money: Int, children: Int): Int {
        if (money < children) {
            return -1
        }

        val toDivide = money - children
        val ans = min(toDivide / 7, children)
        val child = children - ans
        val left = toDivide - ans * 7
        return if (child == 0 && left > 0) {
            ans - 1
        } else if (child == 1 && left == 3) {
            ans - 1
        } else {
            ans
        }

    }
}