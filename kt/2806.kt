class Solution {
    fun accountBalanceAfterPurchase(purchaseAmount: Int): Int {
        return 100 - purchaseAmount.round()
    }

    fun Int.round(): Int {
        return 10 * (this / 10) + if (this % 10 >= 5) 10 else 0
    }
}